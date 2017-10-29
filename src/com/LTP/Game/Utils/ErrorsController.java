package com.LTP.Game.Utils;

import com.LTP.Game.Main.MainController;

//Реализует внутреннюю систему исключений
public class ErrorsController{
    
    //Ссылка на самого себя
    private static Class me;
    
    private ErrorsController(){
        me = getClass();
    }
    
    //Инициализирует ссылку на самого себя
    public static void init(){
        new ErrorsController();
    }
    
    //Метод иммитирует исключение
    public static void throwError(Errors error){
        throwError(error, "");
    }
    
    //Метод иммитирует исключение
    public static void throwError(Errors error, String message){
        MainController.use(me, error.name(), getErrorMessage(error), message);
    }
    
    //Возвращает сообщение из файла локализации, которое ассоциируется с данным типом исключения
    private static String getErrorMessage(Errors error){
        return LocalizationController.get(error.getNumber());
    }
    
}
