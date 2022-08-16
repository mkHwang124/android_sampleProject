package com.example.myapplication.common;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.myapplication.R;

import java.util.ArrayList;

public class RecyclerAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    private ArrayList<RecyclerItem> item = new ArrayList<>();
    private SparseBooleanArray selectedItems = new SparseBooleanArray();
    private int prePosition = -1;
    private Context context;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater를 이용하여 전 단계에서 만들었던 item.xml을 inflate 시킵니다.
        // return 인자는 ViewHolder 입니다.
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_list3, parent, false);
        //view.setId(view.generateViewId());
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ItemViewHolder holder, int position) {
        // Item을 하나, 하나 보여주는(bind 되는) 함수입니다.
        holder.onBind(item.get(position), position);
    }

    @Override
    public int getItemCount() {
        // RecyclerView의 총 개수 입니다.
        return item.size();
    }

    public void addItem(RecyclerItem item) {
        // 외부에서 item을 추가시킬 함수입니다.
        this.item.add(item);
    }

    public class ItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements  View.OnClickListener{
        private TextView textView1;
        private TextView textView2;
        private ImageView imageView;
        private ImageView imageView2;
        private RecyclerItem item;
        private int position;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);
            imageView2 = itemView.findViewById(R.id.imageView4);
        }

        void onBind(RecyclerItem item, int position) {
            this.item = item;
            textView1.setText(item.getTitle());
            textView2.setText(item.getContent());
            imageView.setImageResource(item.getResId());
            imageView2.setImageResource(item.getResId());

            itemView.setOnClickListener(this);
            textView1.setOnClickListener(this);
            textView2.setOnClickListener(this);
            imageView.setOnClickListener(this);

            this.position = position;
            changeVisibility(selectedItems.get(position));
        }

        private void changeVisibility(final boolean isExpanded) {
            int dpValue = 150;
            float d = context.getResources().getDisplayMetrics().density;
            int height= (int)(dpValue * d);

            ValueAnimator va = isExpanded ? ValueAnimator.ofInt(0, height) : ValueAnimator.ofInt(height, 0);

            va.setDuration(600);
            va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int value = (int)animation.getAnimatedValue();

                    imageView2.getLayoutParams().height = value;
                    imageView2.requestLayout();
                    imageView2.setVisibility(isExpanded? View.VISIBLE : View.GONE);
                }
            });
            va.start();
        }

        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.linearItem:
                    if(selectedItems.get(position))
                    {
                        selectedItems.delete(position);
                    }
                    else
                    {
                        selectedItems.delete(prePosition);
                        selectedItems.put(position, true);
                    }

                    if(prePosition != -1) notifyItemChanged(prePosition);
                    notifyItemChanged(position);

                    prePosition = position;

                    break;

            }

        }
    }
}
