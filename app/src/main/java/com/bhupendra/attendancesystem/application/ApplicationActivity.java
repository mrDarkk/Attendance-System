package com.bhupendra.attendancesystem.application;

import android.app.Application;

import com.bhupendra.attendancesystem.utils.TypefaceUtil;


/*
 * DO NOT TOUCH, MAA CHOD DUNGA
 */
public class ApplicationActivity extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "GoogleSans-Regular.ttf"); // font from assets: "assets/fonts/Roboto-Regular.ttf
    }
}
