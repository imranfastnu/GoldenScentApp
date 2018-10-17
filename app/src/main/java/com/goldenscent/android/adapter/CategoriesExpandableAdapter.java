package com.goldenscent.android.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.goldenscent.android.R;
import com.goldenscent.android.model.Category;
import com.goldenscent.android.model.SubCategory;

import java.util.List;

public class CategoriesExpandableAdapter extends ExpandableRecyclerAdapter<CategoriesExpandableAdapter.CategoriesViewHolder, CategoriesExpandableAdapter.SubCategoryViewHolder> {

    private List<Category> categoryList;
    private LayoutInflater mInflater;
    private RecyclerView recyclerView;

    public CategoriesExpandableAdapter(Context context, RecyclerView recyclerView, List<Category> categoryList) {
        super(categoryList);
        mInflater = LayoutInflater.from(context);
        this.recyclerView = recyclerView;
    }


    @Override
    public CategoriesViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View view = mInflater.inflate(R.layout.list_item_category_parent, parentViewGroup, false);
        return new CategoriesViewHolder(view);
    }


    @Override
    public SubCategoryViewHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        View view = mInflater.inflate(R.layout.list_items_category_child, childViewGroup, false);
        return new SubCategoryViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(CategoriesViewHolder categoriesViewHolder, int position, ParentListItem parentListItem) {
        Category category = (Category) parentListItem;
        categoriesViewHolder.bind(category.name);
    }

    @Override
    public void onBindChildViewHolder(SubCategoryViewHolder subCategoryViewHolder, int position, Object childListItem) {
        SubCategory subCategory = (SubCategory) childListItem;
        subCategoryViewHolder.bind(subCategory);
    }

    public static class CategoriesViewHolder extends ParentViewHolder {

        private static final float INITIAL_POSITION = 0.0f;
        private static final float ROTATED_POSITION = 180f;

        @NonNull
        private final ImageButton imageBtnExpandArrow;
        private TextView tvCategory;

        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategory = (TextView) itemView.findViewById(R.id.tvCategory);
            imageBtnExpandArrow = (ImageButton) itemView.findViewById(R.id.imageBtnExpandArrow);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isExpanded()) {
                        collapseView();
                    } else {
                        expandView();
                    }
                }
            });

            imageBtnExpandArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isExpanded()) {
                        collapseView();
                    } else {
                        expandView();
                    }
                }
            });


        }

        public void bind(@NonNull String category) {
            tvCategory.setText(category);
        }

        @SuppressLint("NewApi")
        @Override
        public void setExpanded(boolean expanded) {
            super.setExpanded(expanded);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                if (expanded) {
                    imageBtnExpandArrow.setRotation(ROTATED_POSITION);
                } else {
                    imageBtnExpandArrow.setRotation(INITIAL_POSITION);
                }
            }
        }

        @Override
        public void onExpansionToggled(boolean expanded) {
            super.onExpansionToggled(expanded);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                RotateAnimation rotateAnimation;
                if (expanded) { // rotate clockwise
                    rotateAnimation = new RotateAnimation(ROTATED_POSITION,
                            INITIAL_POSITION,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                } else
                    { // rotate counterclockwise
                    rotateAnimation = new RotateAnimation(-1 * ROTATED_POSITION,
                            INITIAL_POSITION,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                }

                rotateAnimation.setDuration(200);
                rotateAnimation.setFillAfter(true);
                imageBtnExpandArrow.startAnimation(rotateAnimation);
            }
        }

        @Override
        public boolean shouldItemViewClickToggleExpansion() {
            return false;
        }
    }


    public static class SubCategoryViewHolder extends ChildViewHolder {

        public SubCategory mSubCategory;
        public RecyclerView rvSubCategory;

        public SubCategoryViewHolder(View itemView) {
            super(itemView);
            rvSubCategory = (RecyclerView) itemView.findViewById(R.id.rvSubCategory);
        }

        public void bind(@NonNull SubCategory subCategory) {
            mSubCategory = subCategory;
            setupSubCategoryRecyclerView();
        }

        private void setupSubCategoryRecyclerView() {
            RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
            rvSubCategory.setLayoutManager(mLayoutManager);
            rvSubCategory.setHasFixedSize(true);
            rvSubCategory.setNestedScrollingEnabled(false);
            rvSubCategory.setItemAnimator(new DefaultItemAnimator());
            SubCategoryAdapter subCategoryAdapter = new SubCategoryAdapter();
            rvSubCategory.setAdapter(subCategoryAdapter);
        }
    }

}
