package com.example.myapplication.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.common.SingleItem;
import com.example.myapplication.common.SingleItemView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainActivity_fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainActivity_fragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainActivity_fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainActivity_fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static MainActivity_fragment2 newInstance(String param1, String param2) {
        MainActivity_fragment2 fragment = new MainActivity_fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        try
        {
            View view = inflater.inflate(R.layout.fragment_main_activity_fragment2, container, false);
            ListView lvwContent = (ListView)view.findViewById(R.id.listView);

            SingleAdapter adapter = new SingleAdapter();
            adapter.addItem(new SingleItem("title1","content1", R.drawable.ic_launcher_foreground));
            adapter.addItem(new SingleItem("title2","content2", R.drawable.ic_launcher_foreground));
            adapter.addItem(new SingleItem("title3","content3", R.drawable.ic_launcher_foreground));
            adapter.addItem(new SingleItem("title4","content4", R.drawable.ic_launcher_foreground));
            adapter.addItem(new SingleItem("title5","content5", R.drawable.ic_launcher_foreground));

            lvwContent.setAdapter(adapter);

            return view;
        }
        catch (Exception e)
        {
            System.out.println("onCreateView Error");
            return null;
        }
    }

    public class SingleAdapter extends BaseAdapter
    {
        ArrayList<SingleItem> items = new ArrayList<SingleItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingleItem item)
        {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SingleItemView singleItemView = null;
            if(convertView == null)
            {
                singleItemView = new SingleItemView(getActivity().getApplicationContext());
            }
            else
            {
                singleItemView = (SingleItemView)convertView;
            }

            SingleItem item = items.get(position);
            singleItemView.setTitle(item.getTitle());
            singleItemView.setContent(item.getContent());
            singleItemView.setResId(item.getResId());

            return singleItemView;
        }
    }
}