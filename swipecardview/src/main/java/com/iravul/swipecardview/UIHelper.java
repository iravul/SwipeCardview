package com.iravul.swipecardview;

import android.content.Context;
import android.graphics.Point;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;


/**
 * Created by erginkucukiravul on 16/10/15.
 */
public class UIHelper {

    public static int getScreenHeight(Context context) {
        int height;
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        height = size.y;
        return height;
    }


    public static int getContainerHeight(Context context) {
        int height;
        int statusBarHeight = (int) Math.ceil(25 * context.getResources().getDisplayMetrics().density);
        TypedValue tv = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true);
        int actionBarHeight = context.getResources().getDimensionPixelSize(tv.resourceId);
        height = getScreenHeight(context)-actionBarHeight-statusBarHeight;
        return height;
    }


    public static int getScreenWidth(Context context) {
        int width;
        WindowManager wm = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        return width;
    }
}
