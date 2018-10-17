package com.goldenscent.android.model;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

public class Category implements ParentListItem {

    public String name;
    public List<SubCategory> mSubCategories;

    public Category(String name, List<SubCategory> mSubCategories) {
        this.name = name;
        this.mSubCategories = mSubCategories;
    }

    @Override
    public List getChildItemList() {
        return mSubCategories;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
