package com.goldenscent.android.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.goldenscent.android.R;
import com.goldenscent.android.model.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.ViewHolder> {

    private List<SubCategory> mValues;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public ImageView imageViewLogo;
        public TextView tvName;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            imageViewLogo = (ImageView) view.findViewById(R.id.imageViewLogo);
            tvName = (TextView) view.findViewById(R.id.tvName);
        }

    }

    public String getValueAt(int position) {
        return mValues.get(position).name;
    }

    public SubCategoryAdapter() {

        mValues = new ArrayList<>();
        mValues.add(new SubCategory(R.mipmap.icon_lips1, "Pencils"));
        mValues.add(new SubCategory(R.mipmap.icon_lips2, "Lipstick"));
        mValues.add(new SubCategory(R.mipmap.icon_lips3, "Lipgloss"));

        mValues.add(new SubCategory(R.mipmap.icon_lips4, "Lip Balm"));
        mValues.add(new SubCategory(R.mipmap.icon_lips5, "Treatment"));
        mValues.add(new SubCategory(R.mipmap.icon_lips6, "Palette"));
    }


    @Override
    public SubCategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_subcategory, parent, false);
        return new SubCategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SubCategoryAdapter.ViewHolder holder, final int position) {

        holder.imageViewLogo.setBackgroundResource(mValues.get(position).imgResId);
        holder.tvName.setText(mValues.get(position).name);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}