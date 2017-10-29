package com.LTP.Game.Utils;

//Содержит в себе все типы внутренних исключений
public enum Errors {
    
    LANG_LOAD(0),
    ERROR_DOES_NOT_EXIST(1),
    TEXTURES_LOAD(2),
    SETTING_DOES_NOT_EXIST(3),
    TEXTURE_DOES_NOT_EXIST(4);
    
    //Номер исключения в файле локализации
    private final int number;
    
    private Errors(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

}