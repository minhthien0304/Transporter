package com.mrt.transporter.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrt.transporter.AddNewActivity;
import com.mrt.transporter.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFeedFragment extends BaseFragment {

    @BindView(R.id.btnAdd)
    FloatingActionButton btnadd;

    public HomeFeedFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setDisplayResLayoutId() {
        resLayoutId = R.layout.fragment_home_feed;
    }

    @Override
    protected void setData() {

    }

    @OnClick(R.id.btnAdd) void addNew(){
        Intent intent = new Intent(getActivity(), AddNewActivity.class);
        startActivity(intent);
    }

}
