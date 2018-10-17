package com.goldenscent.android.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.goldenscent.android.R;
import com.goldenscent.android.model.Product;

import java.util.List;

public class BestsellersAdapter extends RecyclerView.Adapter<BestsellersAdapter.ViewHolder> {

    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;
    private List<Product> mValues;

    public BestsellersAdapter(Context context, List<Product> items) {
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mBackground = mTypedValue.resourceId;
        mValues = items;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Product mProduct;

        public final View mView;
        public final ImageView mImageView;
        public final TextView tvProductName;
        public final TextView tvProductDescription;
        public final TextView tvProductPrice;
        public final TextView tvPriceDiscountPercent;
        public final Button btnAdd;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (ImageView) view.findViewById(R.id.imageViewLogo);
            tvProductName = (TextView) view.findViewById(R.id.tvName);
            tvProductDescription = (TextView) view.findViewById(R.id.tvDescription);
            tvProductPrice = (TextView) view.findViewById(R.id.tvPrice);
            tvPriceDiscountPercent = (TextView) view.findViewById(R.id.tvPriceAfterDiscount);
            btnAdd = (Button) view.findViewById(R.id.btnAdd);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_bestsellers, parent, false);
        view.setBackgroundResource(mBackground);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        Product product = mValues.get(position);
        holder.mProduct = product;
        holder.mImageView.setBackgroundResource(product.imgResId);
        holder.tvProductName.setText(product.name);
        if (product.desc != null) {
            holder.tvProductDescription.setVisibility(View.VISIBLE);
            holder.tvProductDescription.setText(product.desc);
        } else {
            holder.tvProductDescription.setVisibility(View.GONE);
        }
        holder.tvProductPrice.setText(product.price);

        if (product.priceDiscounted != null && !product.priceDiscounted.isEmpty()) {
            holder.tvProductPrice.setPaintFlags(holder.tvProductPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.tvPriceDiscountPercent.setText(product.priceDiscounted);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        /*Glide.with(holder.mImageView.getContext())
                .load(mValues.get(position).getThumbnail())
                .fitCenter().thumbnail(0.1f)
                .into(holder.mImageView);*/

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}