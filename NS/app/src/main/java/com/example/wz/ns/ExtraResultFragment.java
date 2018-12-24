package com.example.wz.ns;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExtraResultFragment extends AppCompatActivity {


    private String crowd;
    private String originSpoor;
    private String destSpoor;
    private String origin;
    private String dest;
    private String treinType;
    private String uitstapzijde;
    private int pageCount = 1;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_result);

        Intent i = getIntent();
        crowd = i.getStringExtra("Trip");
        originSpoor = i.getStringExtra("originSpoor");
        destSpoor = i.getStringExtra("destSpoor");
        origin = i.getStringExtra("origin");
        dest = i.getStringExtra("dest");
        uitstapzijde = i.getStringExtra("exitSite");
        treinType = i.getStringExtra("trainType");

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }

    public static class PlaceholderFragment extends Fragment {

        @BindView(R.id.view_crowd)
        TextView crowd;

        @BindView(R.id.view_origin)
        TextView origin;

        @BindView(R.id.view_dest)
        TextView dest;

        @BindView(R.id.view_originSpoor)
        TextView originSpoor;

        @BindView(R.id.view_destSpoor)
        TextView destSpoor;

        @BindView(R.id.view_treinType)
        TextView treinType;

        @BindView(R.id.view_uitstapzijde)
        TextView utistapzijde;

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(String crowd, String originSpoor,
                                                      String destSpoor, String origin, String dest,
                                                      String treinType, String uitstapzijde) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putString("crowd", crowd);
            args.putString("originSpoor", originSpoor);
            args.putString("destSpoor", destSpoor);
            args.putString("origin", origin);
            args.putString("dest", dest);
            args.putString("treinType", treinType);
            args.putString("uitstapzijde",uitstapzijde);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_extra_result, container, false);
            ButterKnife.bind(this, rootView);
            crowd.setText(getArguments().getString("crowd"));
            origin.setText(getArguments().getString("origin"));
            dest.setText(getArguments().getString("dest"));
            originSpoor.setText(getArguments().getString("originSpoor"));
            destSpoor.setText(getArguments().getString("destSpoor"));
            treinType.setText(getArguments().getString("treinType"));
            utistapzijde.setText(getArguments().getString("uitstapzijde"));

            return rootView;
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
            return PlaceholderFragment.newInstance(crowd, originSpoor, destSpoor, origin, dest,
                    treinType, uitstapzijde);
        }

        @Override
        public int getCount() {
            // Show 1 total pages.
            return pageCount;
        }
    }
}
