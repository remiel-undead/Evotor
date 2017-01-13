package com.example.undead.evotor.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.undead.evotor.R;
import com.example.undead.evotor.model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {

    private final List<Item> mItemList;

    public ItemListAdapter(final List<Item> itemList) {
        this.mItemList = itemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindItem(mItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView)
        ImageView mImageView;
        @BindView(R.id.nameTextView)
        TextView mNameTextView;

        private final View mView;

        ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }

        void bindItem(final Item item) {
            mNameTextView.setText(item.getName());
            Picasso.with(mView.getContext()).load(item.getImage()).fit().placeholder(R.mipmap.ic_launcher).into(mImageView);
        }
    }
}