package org.polaric.colorful.sample;

import android.app.Application;

import org.polaric.colorful.Colorful;

public class SampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Colorful.defaults()
                .primaryColor(Colorful.ThemeColor.RED)
                .accentColor(Colorful.ThemeColor.BLUE)
                .translucent(false)
                .night(false);

        Colorful.init(this);
    }
}
