package com.mrt.transporter.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;

import com.mrt.transporter.R;

/**
 * Created by DaoMinhThien on 5/12/17.
 */

public class MyEditText extends EditText {

    private String customFont;

    public MyEditText(Context context) {
        super(context);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomFont(context, attrs);

    }

    @Override
    public void onTextChanged(CharSequence text, int start, int lengthBefore,
                              int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        if (text.length() < 0) {
            setCustomF(getContext(), customFont);
        } else {
            setCustomF(getContext(), customFont);
        }
        if (TextUtils.isEmpty(text)) {
            setCustomF(getContext(), customFont);
        }
    }

    private void setCustomFont(Context ctx, AttributeSet attrs) {
        TypedArray ta = ctx.obtainStyledAttributes(attrs, R.styleable.MyFont);
        String myfont = ta.getString(R.styleable.MyFont_font);
        setCustomF(ctx, myfont);
        ta.recycle();
    }

    public boolean setCustomF(Context ctx, String asset) {
        Typeface tf;
        try {
            tf = Typeface.createFromAsset(ctx.getAssets(), asset);
        } catch (Exception e) {
            return false;
        }

        setTypeface(tf);
        return true;
    }
}
