package com.mrt.transporter.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.mrt.transporter.R;
import com.mrt.transporter.adapters.SelectPagerAdapter;

import butterknife.BindView;

public class MainFragment extends BaseFragment {

    @BindView(R.id.tabs)
    TabLayout tabLayout;
    TabLayout.Tab tab;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    ImageView iconTab;
    SelectPagerAdapter adapter;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setDisplayResLayoutId() {
        resLayoutId = R.layout.fragment_main;
    }

    @Override
    protected void setData() {
        setupTabLayout();
    }

    public void setupTabLayout() {
        adapter = new SelectPagerAdapter(getFragmentManager(), getActivity(), "");
        viewPager.setAdapter(adapter);
        //  viewPager.setOffscreenPageLimit(5);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
//                    TabFeedFragment tabFeedFragment = (TabFeedFragment) adapter.getRegisteredFragment(0);
//                    tabFeedFragment.scollRecyclerView();

                }
            }
        });
        viewPager.setOffscreenPageLimit(2);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tab = tabLayout.getTabAt(i);
            tab.setCustomView(adapter.getTabView(i));
//            initTab();
            iconTab = (ImageView) tab.getCustomView().findViewById(R.id.imgItemTabView);
        }
    }

}
