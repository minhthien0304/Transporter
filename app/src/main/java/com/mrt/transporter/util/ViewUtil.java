package com.mrt.transporter.util;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.mrt.transporter.R;
import com.mrt.transporter.customview.MyTextView;

/**
 * Created by DaoMinhThien on 6/3/17.
 */

public class ViewUtil {
    public static void toolbarConfig(AppCompatActivity activity, Toolbar toolbar, String title){
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setDisplayShowHomeEnabled(true);
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
//        MyTextView mtvTitle = (MyTextView) toolbar.findViewById(R.id.tvTitleToolbar);
//        mtvTitle.setText(title);

    }
}
