package com.example.undead.evotor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.undead.evotor.R;
import com.example.undead.evotor.adapter.ItemListAdapter;
import com.example.undead.evotor.model.Item;
import com.example.undead.evotor.presenter.ItemListPresenter;
import com.example.undead.evotor.presenter.ItemListPresenterImpl;
import com.example.undead.evotor.view_interface.ItemListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemListFragment extends BaseFragment implements ItemListView {
    private static final String ARG_SECTION_NUMBER = "section_number";

    @BindView(R.id.listView)
    RecyclerView mRecyclerView;

    private ItemListPresenter mItemListPresenter;
    private int mSectionNumber;

    public ItemListFragment() {
    }

    public static ItemListFragment newInstance(int sectionNumber) {
        ItemListFragment fragment = new ItemListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mSectionNumber = getArguments().getInt(ARG_SECTION_NUMBER, 1);
        mItemListPresenter = new ItemListPresenterImpl(this, this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mItemListPresenter.unsubscribe();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showEmptyMessage();
        fetchSection();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_SECTION_NUMBER, mSectionNumber);
    }

    private void fetchSection() {
        switch (mSectionNumber) {
            case 1:
                mItemListPresenter.fetchSection1();
                break;
            case 2:
                mItemListPresenter.fetchSection2();
                break;
            case 3:
                mItemListPresenter.fetchSection3();
                break;
            default:
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mUnbinder = ButterKnife.bind(this, rootView);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(new ItemListAdapter(new ArrayList<Item>()));
        return rootView;
    }

    @Override
    public void setRssItemList(List<Item> itemList) {
        mRecyclerView.swapAdapter(new ItemListAdapter(itemList), false);
    }
}