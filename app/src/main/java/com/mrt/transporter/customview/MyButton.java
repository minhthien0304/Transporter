package com.mrt.transporter.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

import com.mrt.transporter.R;

/**
 * Created by DaoMinhThien on 5/8/17.
 */

public class MyButton extends Button {

    public static final String NAME = MyButton.class.getName();

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context,attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomFont(context,attrs);
    }

    private void setCustomFont(Context ctx, AttributeSet attrs){
        TypedArray ta = ctx.obtainStyledAttributes(attrs, R.styleable.MyFont);
        String myfont = ta.getString(R.styleable.MyFont_font);
        setFont(ctx, myfont);
    }

    public void setFont(Context ctx, String assets){
        Typeface tf = null;
        try {
            tf = Typeface.createFromAsset(ctx.getAssets(), assets);
        }catch (Exception ex){
            Log.e(NAME + ":" , ex.getMessage());
        }
        setTypeface(tf);
    }
}
