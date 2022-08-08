package com.example.myapplication.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myapplication.R;

public class SingleItemView extends ConstraintLayout {

    TextView textView, textView2;
    ImageView imageView;

    public SingleItemView(@NonNull Context context) {
        super(context);
        init(context);
    }

    private void init(Context context)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.fragment2_item_recycler, this,true);
        textView = findViewById(R.id.textView10);
        textView2 =findViewById(R.id.textView11);
        imageView = findViewById(R.id.imageView2);
    }

    public void setTitle(String title)
    {
        textView.setText(title);
    }

    public void setContent(String content)
    {
        textView2.setText(content);
    }

    public void setResId(int resId)
    {
        imageView.setImageResource(resId);
    }
}
