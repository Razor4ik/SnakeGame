package com.LTP.Game.Utils;

import java.util.HashMap;
import java.util.Map;

//Класс содержит в себе константы
public abstract class Constants {
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String name = "PVT Game";
    
    public static final int STEP = 1;
    public static final int FPS = 50;
    
    //Все настройки игры храняться здесь в виде: SettingName, value
    private static final Map<String, String> settings = new HashMap<>();
    
    //Нужна для разработки и дебага
    private static final boolean DEBUG = true;
    
    //Содержит путь к папке с ресурсами
    public static final String SRC;
    
    static{
        if(DEBUG){
            SRC = "D:\\GameMenu\\src\\com\\LTP\\Game\\res";
        }else{
            SRC = "com\\LTP\\Game\\res";
        }
        //Установка языка игры
        settings.put("Lang", Lang.RU.name());
    }
    
    //Установка нового значения существующего сеттинга
    public static void setSetting(String name, String value){
        if(settings.containsKey(name))
            settings.replace(name, value);
    }
    
    //Возвращает значение определенного сеттинга
    public static String getSetting(String name){
        if(settings.containsKey(name))
            return settings.get(name);
        
        //Если сеттинг с заданным именем отсутствует, то выбрасывается исключение
        ErrorsController.throwError(Errors.SETTING_DOES_NOT_EXIST, name);
        return null;
    }
    
}
