package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.common.RecyclerAdapter;
import com.example.myapplication.common.RecyclerItem;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainActivity_fragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainActivity_fragment3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainActivity_fragment3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainActivity_fragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static MainActivity_fragment3 newInstance(String param1, String param2) {
        MainActivity_fragment3 fragment = new MainActivity_fragment3();
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
        View view = inflater.inflate(R.layout.fragment_main_activity_list3, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerAdapter adapter = new RecyclerAdapter();
        adapter.addItem(new RecyclerItem("title1","content1",R.drawable.git_image));
        adapter.addItem(new RecyclerItem("title2","content2",R.drawable.git_image));
        adapter.addItem(new RecyclerItem("title3","content3",R.drawable.git_image));
        adapter.addItem(new RecyclerItem("title4","content4",R.drawable.git_image));
        adapter.addItem(new RecyclerItem("title5","content5",R.drawable.git_image));
        adapter.addItem(new RecyclerItem("title6","content6",R.drawable.git_image));
        adapter.addItem(new RecyclerItem("title7","content7",R.drawable.git_image));
        adapter.addItem(new RecyclerItem("title8","content8",R.drawable.git_image));
        adapter.notifyDataSetChanged();

        recyclerView.setAdapter(adapter);

        return view;
    }
}