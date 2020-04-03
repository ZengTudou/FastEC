package com.tudou.fastec.latte.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 用于配置文件存储
 */
public class Configurator {

    private static final HashMap<String, Object> LATTE_CONFIGS = new HashMap<>();// 创建数据结构来存储配置
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>(); // 封装iconify

    private Configurator(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);  //配置开始，还没有完成

    }

    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }
    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    final HashMap<String, Object> getLatteConfigs(){
        return LATTE_CONFIGS;
    }
    public final void configure(){
        initIcons();
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);  // 配置好了
    }

    public final Configurator withApiHost(String host){  //这里返回Configurator是为了链式API
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }
    public final Configurator withIcons(IconFontDescriptor descriptor){
        ICONS.add(descriptor);
        return this;
    }

    private void initIcons(){
        if(ICONS.size() > 0){
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for(int i=1; i<ICONS.size(); i++){
                initializer.with(ICONS.get(i));
            }
        }
    }
    //在应用程序获取配置的时候调用
    private void checkConfiguration(){
        final boolean isReady = (boolean)LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if(!isReady){
            throw new RuntimeException("Configuration is not ready, call configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key){
        checkConfiguration();
        return (T)LATTE_CONFIGS.get(key.name());
    }
}
