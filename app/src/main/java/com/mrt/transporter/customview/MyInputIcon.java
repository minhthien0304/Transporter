package com.mrt.transporter.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.mrt.transporter.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DaoMinhThien on 5/11/17.
 */

public class MyInputIcon extends FrameLayout{

    private final String TAG = MyInputIcon.class.getName();

    View root;
    @BindView(R.id.imgicon)
    ImageView imgIcon;
    @BindView(R.id.text_input_layout)
    TextInputLayout inputLayout;
    @BindView(R.id.textInputEditText)
    MyEditText etText;

    public MyInputIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(root == null){
            root = LayoutInflater.from(context).inflate(R.layout.text_input_icon, this, false);
            ButterKnife.bind(this,root);
            addView(root);
        }
        setCustomImage(context, attrs);
        setHintText(context, attrs);
    }

    private void setCustomImage(Context ctx, AttributeSet attrs){
        TypedArray ta = ctx.obtainStyledAttributes(attrs, R.styleable.MyIcon);
        int resImg = ta.getResourceId(R.styleable.MyIcon_icon_input,0);
        setImageIc(resImg);
    }

    private void setHintText(Context ctx, AttributeSet attrs){
        TypedArray ta = ctx.obtainStyledAttributes(attrs, R.styleable.MyHintText);
        String hint = ta.getString(R.styleable.MyHintText_hintText);
        setTextHint(hint);
    }

    public void setImageIc(int rs){
        imgIcon.setBackgroundResource(rs);
    }

    public void setTextHint(String text){
        inputLayout.setHint(text);
    }

    public void setTypeEt(int rs){
        etText.setInputType(InputType.TYPE_CLASS_TEXT|rs);
    }

    public String getTextEt(){
        return etText.getText().toString();
    }

    public void setError(String error){
        etText.setError(error);
    }

//    public void setTypeText(){ etText.setInputType(InputType.TYPE_CLASS_TEXT | );}
}
