package com.goldenscent.android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.goldenscent.android.adapter.BestsellersAdapter;
import com.goldenscent.android.model.Product;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private List<Product> productList;
    private BestsellersAdapter adapterBestseller;

    private TextView tvViewAll;
    private RecyclerView rvBestSellers;

    public HomeFragment() {

    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        tvViewAll= view.findViewById(R.id.tvViewAll);
        rvBestSellers  = view.findViewById(R.id.rvBestSellers);

        setupBestsellersRecyclerView();

        return view;
    }

    private void setupBestsellersRecyclerView() {
        initializeProduct();
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL);
        rvBestSellers.setLayoutManager(mLayoutManager);

        rvBestSellers.setHasFixedSize(true);
        rvBestSellers.setNestedScrollingEnabled(false);
        //Drawable dividerDrawable = ContextCompat.getDrawable(getActivity(), R.drawable.divider_vertical);
        //rvRecommendedProducts.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        rvBestSellers.setItemAnimator(new DefaultItemAnimator());
        adapterBestseller = new BestsellersAdapter(getActivity(), productList);
        rvBestSellers.setAdapter(adapterBestseller);
    }


    private void initializeProduct(){
        productList = new ArrayList<>();
        productList.add(new Product(R.mipmap.icon_bestseller1, "PRADA", "Candy", "348 SR", "121 SR"));
        productList.add(new Product(R.mipmap.icon_bestseller2, "Dolge & Gabana sweet perfume", "The one text goes here untill the end for the layout", "348 SR", ""));
        productList.add(new Product(R.mipmap.icon_bestseller3, "Aigner", "N. 1", "348 SR", ""));

        productList.add(new Product(R.mipmap.icon_bestseller1, "PRADA", "Candy", "348 SR", "121 SR"));
        productList.add(new Product(R.mipmap.icon_bestseller2, "Dolge & Gabana sweet perfume", "The one text goes here untill the end for the layout", "348 SR", ""));
        productList.add(new Product(R.mipmap.icon_bestseller3, "Aigner", "N. 1", "348 SR", ""));

        productList.add(new Product(R.mipmap.icon_bestseller1, "PRADA", "Candy", "348 SR", "121 SR"));
        productList.add(new Product(R.mipmap.icon_bestseller2, "Dolge & Gabana sweet perfume", "The one text goes here untill the end for the layout", "348 SR", ""));
        productList.add(new Product(R.mipmap.icon_bestseller3, "Aigner", "N. 1", "348 SR", ""));
    }

}
