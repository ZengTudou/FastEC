package com.tudou.fastec.example;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.tudou.fastec.latte.app.Latte;
import com.tudou.fastec.latte.ec.icon.FontEcModule;

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcons(new FontAwesomeModule())
                .withIcons(new FontEcModule())
                .withApiHost("http://127.0.0.1")
                .configure();
    }
}
