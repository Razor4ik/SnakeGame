package com.LTP.Game.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Отвечает за подгрузку сообщений при разных локализациях
public class LocalizationController{
    
    private LocalizationController(){}
    
    //Здесь храняться все фразы, в определенном порядке
    private static final List<String> phrases = new ArrayList<>();
    
    //запускает загрузчик фраз
    public static void init(){
        Load(Constants.getSetting("Lang"));
    }
    
    //Загружает все фразы локализации
    private static void Load(String lang){
        String paths[] = {
          "/langs/Errors/"  
        };
        
        if(lang.equals("EN"))
            phrases.add("Can't load lang file, check for it or report to author");
        else if(lang.equals("RU"))
            phrases.add("Не удалось загрузить языковой файл, проверьте, существует ли он или сообщите разработчику");
                
        for(String path : paths){
            try{
                String content = new String(Files.readAllBytes(Paths.get(Constants.SRC + path + lang + ".lang")));

                phrases.addAll(Arrays.asList(content.split("\n")));

            }catch(IOException e){
                ErrorsController.throwError(Errors.LANG_LOAD, path);
            }
        }
    }
    
    //Возвражает фразу ассоциируемую с неким номером
    public static String get(int number){
        if(number < 0 || number >= phrases.size()){
            ErrorsController.throwError(Errors.ERROR_DOES_NOT_EXIST);
            return null;
        }
        
        return phrases.get(number);
        
    }
    
}
