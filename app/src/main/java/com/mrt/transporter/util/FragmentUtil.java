package com.mrt.transporter.util;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 * Created by DaoMinhThien on 7/15/17.
 */

public class FragmentUtil {
    public static void showDialog(FragmentManager fm, DialogFragment dlg, String flag) {
        FragmentTransaction ft = fm.beginTransaction();
        dlg.show(ft, flag);

    }

    public static void showFragment(int container_id, FragmentManager fm, Fragment fragment, String flag, boolean addToBackStack) {
        FragmentTransaction ft = fm.beginTransaction();
        if (addToBackStack) {
            ft.addToBackStack(null);
        }
        ft.replace(container_id, fragment, flag).commit();
    }
}
