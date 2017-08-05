package com.mrt.transporter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;

import com.mrt.transporter.customview.MyButton;
import com.mrt.transporter.customview.MyInputIcon;
import com.mrt.transporter.customview.MyTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends BaseActivity {

    @BindView(R.id.etUser)
    MyInputIcon etUser;
    @BindView(R.id.etPass)
    MyInputIcon etPass;
    @BindView(R.id.tvCreateAcc)
    MyTextView tvCreateAcc;
    @BindView(R.id.btnLogin)
    MyButton btnLogin;


    @Override
    public void setLayout() {
        res = R.layout.activity_login;
    }

    @Override
    public void setData() {
        initView();
    }

    private void initView(){
        etPass.setTypeEt(InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }


    @OnClick({R.id.tvCreateAcc,R.id.btnLogin}) void actionClick(View v){
        switch (v.getId()){
            case R.id.tvCreateAcc:
                Intent intent = new Intent(this, SignUpActivity.class);
                startActivity(intent);
                break;
            case R.id.btnLogin:
                Intent main = new Intent(this, MainActivity.class);
                startActivity(main);
                finish();
        }
    }


}
