package com.example.wz.ns;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wz.ns.model.Leg;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExtraResultFragment extends AppCompatActivity {


    private String crowd;


    private int pageCount = 1;
    private static List<Leg> legs;

    private int priceCent;
    private double priceFloat;
    private String price;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_result);


        //get the legs of the trip from the result activity
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("bundle");
        legs = (ArrayList<Leg>) args.getSerializable("list");
        priceCent = intent.getIntExtra("price", -1);
        crowd = intent.getStringExtra("crowd");

        ///+0 is to fix the convertion to price
        priceFloat = priceCent + 0 / 100.0;

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        DecimalFormat decimalFormat = new DecimalFormat("€ #,##", symbols);

        price = decimalFormat.format(priceFloat);


        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }

    public static class PlaceholderFragment extends Fragment implements ExtraResultAdapter.ExtraResultAdapterClickListener {

        @BindView(R.id.view_crowd)
        TextView crowd;

        @BindView(R.id.view_price)
        TextView price;

        @BindView(R.id.extra_result_recyclerView)
        RecyclerView mRecyclerView;


        ExtraResultAdapter mAdapter;

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(String crowd, String price) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putString("crowd", crowd);
            args.putString("price", price);


            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_extra_result, container, false);
            ButterKnife.bind(this, rootView);
            crowd.setText(getArguments().getString("crowd"));
            price.setText(getArguments().getString("price"));

            setUpRecycleView();

            return rootView;
        }


        private void setUpRecycleView() {
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
            mRecyclerView.setLayoutManager(mLayoutManager);
            mAdapter = new ExtraResultAdapter(legs, this);
            mRecyclerView.setAdapter(mAdapter);
        }

        @Override
        public void ExtraResultAdapterOnClick(int i) {

        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(crowd, price);
        }

        @Override
        public int getCount() {
            // Show 1 total pages.
            return pageCount;
        }
    }
}
