package com.goldenscent.android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.goldenscent.android.R;
import com.goldenscent.android.model.SideMenu;
import com.goldenscent.android.view.CheckableLinearLayout;

import java.util.ArrayList;
import java.util.List;

public class SideMenuAdapter extends RecyclerView.Adapter<SideMenuAdapter.ViewHolder> {

    private RecyclerView rvMenuOptions;
    private List<SideMenu> mValues;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public View viewDivider;
        public ImageView ivIcon;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ivIcon = (ImageView) view.findViewById(R.id.ivIcon);
            viewDivider = view.findViewById(R.id.viewDivider);
        }

    }

    public String getValueAt(int position) {
        return mValues.get(position).name;
    }

    public SideMenuAdapter(Context context) {

        mValues = new ArrayList<>();
        mValues.add(new SideMenu(R.mipmap.icon_menu1, "Makeup"));
        mValues.add(new SideMenu(R.mipmap.icon_menu2, "Skincare"));
        mValues.add(new SideMenu(R.mipmap.icon_menu3, "Haircare"));

        mValues.add(new SideMenu(R.mipmap.icon_menu4, "Beauty Tools"));
        mValues.add(new SideMenu(R.mipmap.icon_menu5, "Home Fragrances"));
        mValues.add(new SideMenu(R.mipmap.icon_menu6, "Gift"));

        mValues.add(new SideMenu(R.mipmap.icon_menu7, "Men"));

    }

    public void setRecyclerView(RecyclerView recyclerView){
        this.rvMenuOptions = recyclerView;
    }


    private void onCheckedChange(){
        for(int i=0; i< this.getItemCount(); i++){
            SideMenuAdapter.ViewHolder holder = (SideMenuAdapter.ViewHolder)rvMenuOptions.findViewHolderForLayoutPosition(i);
            ((CheckableLinearLayout)holder.mView).setChecked(false);
            holder.viewDivider.setVisibility(View.GONE);
        }
    }

    @Override
    public SideMenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_home_sidemenu, parent, false);
        return new SideMenuAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SideMenuAdapter.ViewHolder holder, final int position) {

        holder.ivIcon.setBackgroundResource(mValues.get(position).imgResId);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCheckedChange();
                if (((CheckableLinearLayout) v).isChecked()) {
                    ((CheckableLinearLayout) v).setChecked(false);
                    holder.viewDivider.setVisibility(View.GONE);
                } else {
                    ((CheckableLinearLayout) v).setChecked(true);
                    holder.viewDivider.setVisibility(View.VISIBLE);
                }
            }
        });

        if (position == 0) {
            ((CheckableLinearLayout)holder.mView).setChecked(true);
            holder.viewDivider.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}