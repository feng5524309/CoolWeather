package com.tsn.coolweather;

import android.app.Application;
import android.content.Context;

public class SunnyWeatherApplication extends Application {
    private static Context context;
    private static String TOKEN="";

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
