package com.example.undead.evotor.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.undead.evotor.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemListFragment extends BaseFragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    @BindView(R.id.listView)
    RecyclerView mRecyclerView;

    public ItemListFragment() { }

    public static ItemListFragment newInstance(int sectionNumber) {
        ItemListFragment fragment = new ItemListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mUnbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }
}