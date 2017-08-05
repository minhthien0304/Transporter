package com.mrt.transporter;

import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.mrt.transporter.customview.ItemMenu;
import com.mrt.transporter.fragment.MainFragment;
import com.mrt.transporter.util.FragmentUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.iconBack)
    ImageView imgView;
    @BindView(R.id.drawer_layout)
    DrawerLayout dlLayout;
    @BindView(R.id.leftLayoutMenu)
    LinearLayout leftLayoutMenu;
    @BindView(R.id.lnMenu)
    LinearLayout lnMenu;
    @BindView(R.id.menuHome)
    ItemMenu menuHome;
    @BindView(R.id.menuSetting)
    ItemMenu menuSetting;
    @BindView(R.id.menuChart)
    ItemMenu menuChart;
    @BindView(R.id.menuLogout)
    ItemMenu menuLogout;
    private int select = 0;


    @Override
    public void setLayout() {
        res = R.layout.activity_main;
    }

    @Override
    public void setData() {
        imgView.setImageResource(R.drawable.ic_dehaze_white_24dp);
        initView();
    }

    private void initView() {
        FragmentUtil.showFragment(R.id.mainFrame, getFragmentManager(), new MainFragment(), MainFragment.class.getName(), false);
    }

    @OnClick({R.id.backIcon})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.backIcon:
                dlLayout.openDrawer(leftLayoutMenu);
                break;
        }
    }

    @OnClick({R.id.menuHome, R.id.menuChart, R.id.menuSetting, R.id.menuLogout})
    void onClickMenu(View view) {
        setDefaultColorMenu();
        switch (view.getId()) {
            case R.id.menuHome:
                menuHome.setBackgroundSelected(getResources().getColor(R.color.colorNavigationBarSelected));
                this.select = 0;
                Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuChart:
                menuChart.setBackgroundSelected(getResources().getColor(R.color.colorNavigationBarSelected));
                this.select = 2;
                Toast.makeText(this, "Chart clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuSetting:
                menuSetting.setBackgroundSelected(getResources().getColor(R.color.colorNavigationBarSelected));
                this.select = 4;
                Toast.makeText(this, "Setting clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuLogout:
                menuLogout.setBackgroundSelected(getResources().getColor(R.color.colorNavigationBarSelected));
                this.select = 6;
                Toast.makeText(this, "Logout clicked", Toast.LENGTH_SHORT).show();
                break;

        }
        dlLayout.closeDrawer(leftLayoutMenu);
    }

    private void setDefaultColorMenu() {
        ItemMenu item = (ItemMenu) lnMenu.getChildAt(select);
        item.setBackgroundSelected(getResources().getColor(R.color.colorNavigationBar));
    }
}
