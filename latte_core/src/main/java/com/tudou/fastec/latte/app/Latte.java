package com.tudou.fastec.latte.app;

import android.content.Context;

import java.util.HashMap;

/**
 * 用于管理整个app，不希望别人修改，弄成Final
 */
public final class Latte {

    public static Configurator init(Context context){
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context);
        return Configurator.getInstance();
    }

    private static HashMap<String, Object> getConfigurations(){
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Context getApplication(){
        return  (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
    }
}
