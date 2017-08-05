package com.mrt.transporter.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mrt.transporter.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DaoMinhThien on 7/17/17.
 */

public class ItemMenu extends FrameLayout {
    View root;
    @BindView(R.id.icon_menu)
    ImageView iconMenu;
    @BindView(R.id.tv_menu)
    MyTextView tvMenu;
    @BindView(R.id.ly_menu)
    LinearLayout lyMenu;

    public ItemMenu(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context,attrs);
        if (root==null) {
            root = LayoutInflater.from(context).inflate(R.layout.my_item_menu, this, false);
        }
        ButterKnife.bind(this,root);
        addView(root);
        setData(context,attrs);
    }

//    public ItemMenu(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, View root) {
//        super(context, attrs, defStyleAttr);
//        if (root==null) {
//            root = LayoutInflater.from(context).inflate(R.layout.text_input_icon, this, false);
//        }
//        ButterKnife.bind(this,root);
//        addView(root);
//        setData(context,attrs);
//    }

    public void setData(Context ctx, AttributeSet attrs){
        TypedArray ta = ctx.obtainStyledAttributes(attrs, R.styleable.MyMenu);
        int resImg = ta.getResourceId(R.styleable.MyMenu_img_res,0);
        iconMenu.setImageResource(resImg);
        String text = ta.getString(R.styleable.MyMenu_text);
        tvMenu.setText(text);
        ta.recycle();
    }

    public void setBackgroundSelected(int color){
        lyMenu.setBackgroundColor(color);
    }

    @Override
    public boolean hasOnClickListeners() {
        return super.hasOnClickListeners();
    }
}
