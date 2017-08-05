package com.mrt.transporter.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mrt.transporter.R;
import com.mrt.transporter.fragment.HomeFeedFragment;
import com.mrt.transporter.fragment.MapFeedFragment;
import com.mrt.transporter.fragment.TodoFragment;

/**
 * Created by DaoMinhThien on 5/24/16.
 */
public class SelectPagerAdapter extends FragmentStatePagerAdapter {
    String userId;
    SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();
    private Context context;
    final int PAGE_COUNT = 3;
    private int[] tabImage = {
            R.drawable.ic_globe,
            R.drawable.ic_map,
            R.drawable.ic_map

    };
//    private String[] tabName;

    public SelectPagerAdapter(FragmentManager manager, Context context, String userId) {
        super(manager);
        this.context = context;
        this.userId = userId;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFeedFragment();
            case 1:
               return new MapFeedFragment();
            case 2:
                return new TodoFragment();
        }
        return null;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }
    public boolean isNetworkOnline() {
        boolean status=false;
        try{
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getNetworkInfo(0);
            if (netInfo != null && netInfo.getState()== NetworkInfo.State.CONNECTED) {
                status= true;
            }else {
                netInfo = cm.getNetworkInfo(1);
                if(netInfo!=null && netInfo.getState()== NetworkInfo.State.CONNECTED)
                    status= true;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return status;

    }
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    public View getTabView(int position) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_tabs, null);
        ImageView tvItemTab = (ImageView) v.findViewById(R.id.imgItemTabView);
//        MyTextView textView = (MyTextView) v.findViewById(R.id.tvItemTab);
        tvItemTab.setImageDrawable(context.getResources().getDrawable(tabImage[position]));
//        if (position==3){
//            MyTextView myTextView = (MyTextView) v.findViewById(R.id.sumnoti);
//            myTextView.setVisibility(View.VISIBLE);
//        }
//        textView.setText(tabName[position]);
        return v;
    }
}
