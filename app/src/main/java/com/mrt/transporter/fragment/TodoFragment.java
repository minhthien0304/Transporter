package com.mrt.transporter.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrt.transporter.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodoFragment extends BaseFragment {


    public TodoFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setDisplayResLayoutId() {
        resLayoutId = R.layout.fragment_todo;
    }

    @Override
    protected void setData() {

    }

}
