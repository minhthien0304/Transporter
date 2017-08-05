package com.mrt.transporter.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrt.transporter.R;
import com.mrt.transporter.SignUpActivity;
import com.mrt.transporter.customview.MyButton;
import com.mrt.transporter.customview.MyInputIcon;
import com.mrt.transporter.customview.MyTextView;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseFragment {

    @BindView(R.id.etUser)
    MyInputIcon etUser;
    @BindView(R.id.etPass)
    MyInputIcon etPass;
    @BindView(R.id.tvCreateAcc)
    MyTextView tvCreateAcc;
    @BindView(R.id.btnLogin)
    MyButton btnLogin;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setDisplayResLayoutId() {
        resLayoutId = R.layout.fragment_login;
    }

    @Override
    protected void setData() {
        initView();
    }

    private void initView(){
//        etPass.setTypeText();
    }

    @OnClick({R.id.tvCreateAcc,R.id.btnLogin}) void actionClick(View v){
        switch (v.getId()){
            case R.id.tvCreateAcc:

                break;
        }
    }


}
