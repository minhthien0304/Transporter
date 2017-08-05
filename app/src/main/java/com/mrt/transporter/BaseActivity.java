package com.mrt.transporter;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by DaoMinhThien on 6/1/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @LayoutRes
    public int res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout();
        setContentView(res);
        ButterKnife.bind(this);
        setData();
    }

    public abstract void setLayout();
    public abstract void setData();
}
