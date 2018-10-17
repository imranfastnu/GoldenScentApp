package com.goldenscent.android;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.goldenscent.android.adapter.BestsellersAdapter;
import com.goldenscent.android.adapter.CategoriesExpandableAdapter;
import com.goldenscent.android.model.Category;
import com.goldenscent.android.model.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private Context context;
    private List<Category> categoryList;
    private BestsellersAdapter adapterBestseller;

    private TextView tvViewAll;
    private RecyclerView rvBestSellers;
    private RecyclerView rvCategory;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        tvViewAll= view.findViewById(R.id.tvViewAll);
        rvBestSellers  = view.findViewById(R.id.rvBestSellers);
        rvCategory  = view.findViewById(R.id.rvCategory);

        setupBestsellersRecyclerView();
        setupCategoryRecyclerView();

        return view;
    }


    private void setupBestsellersRecyclerView() {
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL);
        rvBestSellers.setLayoutManager(mLayoutManager);

        rvBestSellers.setHasFixedSize(true);
        rvBestSellers.setNestedScrollingEnabled(false);
        rvBestSellers.setItemAnimator(new DefaultItemAnimator());
        adapterBestseller = new BestsellersAdapter(getActivity());
        rvBestSellers.setAdapter(adapterBestseller);
    }

    private void setupCategoryRecyclerView(){
        initializeCategories();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false);
        rvCategory.setLayoutManager(mLayoutManager);
        rvCategory.setNestedScrollingEnabled(false);
        rvCategory.setItemAnimator(new DefaultItemAnimator());
        CategoriesExpandableAdapter mAdapter = new CategoriesExpandableAdapter(getActivity(), rvCategory, categoryList);
        rvCategory.setAdapter(mAdapter);

        //Expand first item
        mAdapter.expandParent(0);
    }



    private void initializeCategories(){
        //Lips
        List<SubCategory> lipsSubCategories = new ArrayList<>();
        lipsSubCategories.add(new SubCategory(R.mipmap.icon_lips1, "Subcategory"));

        categoryList = new ArrayList<>();
        categoryList.add(new Category("Lips", lipsSubCategories));
        categoryList.add(new Category("Face", lipsSubCategories));
        categoryList.add(new Category("Nails", lipsSubCategories));
    }
}
