package com.mrt.transporter;

import android.text.InputType;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RelativeLayout;


import com.google.firebase.auth.FirebaseAuth;
import com.mrt.transporter.customview.MyEditText;
import com.mrt.transporter.customview.MyInputIcon;

import butterknife.BindView;
import butterknife.OnClick;

public class SignUpActivity extends BaseActivity {

    @BindView(R.id.backIcon)
    RelativeLayout backIcon;
    @BindView(R.id.etEmail)
    MyInputIcon etEmail;
    @BindView(R.id.etPass)
    MyInputIcon etPass;
    @BindView(R.id.etFName)
    MyInputIcon etFName;
    @BindView(R.id.etLastName)
    MyEditText etLastName;
    @BindView(R.id.etPhone)
    MyInputIcon etPhone;
    @BindView(R.id.etDob)
    MyInputIcon etDob;
    @BindView(R.id.rbmale)
    RadioButton rbmale;
    @BindView(R.id.rbFemale)
    RadioButton rbFemale;

    private FirebaseAuth mAuth;

    @Override
    public void setLayout() {
        res = R.layout.activity_sign_up;
    }

    private void initLayout() {
        etEmail.setTypeEt(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        etPass.setTypeEt(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        etFName.setTypeEt(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        etPhone.setTypeEt(InputType.TYPE_CLASS_PHONE);
        etDob.setTypeEt(InputType.TYPE_CLASS_DATETIME);
    }

    @Override
    public void setData() {
        initLayout();

        mAuth = FirebaseAuth.getInstance();
    }

    @OnClick({R.id.rbmale, R.id.rbFemale}) void genderClick(View v){
        switch (v.getId()){
            case R.id.rbFemale:
                rbmale.setChecked(false);
                rbFemale.setChecked(true);
                break;
            case R.id.rbmale:
                rbFemale.setChecked(false);
                rbmale.setChecked(true);
                break;
        }
    }

    @OnClick({R.id.backIcon}) void actionClick(View v){
        switch (v.getId()){
            case R.id.backIcon: finish();
        }
    }

    @OnClick(R.id.tvCreateAcc) void registerUser(){
        String email = etEmail.getTextEt();
        String pass = etPass.getTextEt();
        String phone = etPhone.getTextEt();
        String fName = etFName.getTextEt();
        String lName = etLastName.getText().toString();
        String dob = etDob.getTextEt();
    }
}
