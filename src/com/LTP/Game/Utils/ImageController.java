package com.LTP.Game.Utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

//Отвечает за загрузку и передачу текстур
public class ImageController {
    
    //Здесь хранятся текстуры в виде: name, image
    private static final Map<String, Image> sprites = new HashMap<>();
    
    private ImageController(){}
    
    //Загружает текстуру с данным именем из данного каталога
    private static void load(String name, String src){
        load(name, name, src);
    }
    
    //Загружает текстуру с данным именем из данного каталога
    private static void load(String name, String fileName, String src){
        try{
            sprites.put(name, ImageIO.read(new File(Constants.SRC + src + fileName + ".png")));
        }catch(IOException e){ErrorsController.throwError(Errors.TEXTURES_LOAD, name);}
    }
    
    //Загружает текстуру с данным именем из данного каталога
    private static void load(String name, String fileName, String src, String extension){
        try{
            sprites.put(name, ImageIO.read(new File(Constants.SRC + src + fileName + extension)));
        }catch(IOException e){ErrorsController.throwError(Errors.TEXTURES_LOAD, name);}
    }
    
    //Загружает все текстуры используемые в игре
    public static void loadAll(){
        load("End0", "/Snake/");
        load("End1", "/Snake/");
        load("End2", "/Snake/");
        load("End3", "/Snake/");
        load("Turn0_1", "/Snake/");
        load("Turn0_3", "/Snake/");
        load("Turn1_2", "/Snake/");
        load("Turn2_3", "/Snake/");
        load("HorisontalPart", "/Snake/");
        load("VerticalPart", "/Snake/");
        load("Exit", "Exit", "/" + Constants.getSetting("Lang") + "/menu/buttons/", ".jpg");
        load("New Game", "New Game", "/" + Constants.getSetting("Lang") + "/menu/buttons/", ".jpg");
        load("Settings", "Settings", "/" + Constants.getSetting("Lang") + "/menu/buttons/", ".jpg");
        load("Stat", "Stat", "/" + Constants.getSetting("Lang") + "/menu/buttons/", ".jpg");
        load("Exit_big", "Exit", "/" + Constants.getSetting("Lang") + "/menu/big_buttons/", ".jpg");
        load("New Game_big", "New Game", "/" + Constants.getSetting("Lang") + "/menu/big_buttons/", ".jpg");
        load("Settings_big", "Settings", "/" + Constants.getSetting("Lang") + "/menu/big_buttons/", ".jpg");
        load("Stat_big", "Stat", "/" + Constants.getSetting("Lang") + "/menu/big_buttons/", ".jpg");
    }
    
    //Передает текстуру
    public static Image get(String name){
        if(!sprites.containsKey(name))
            //При ее отсутствии выбрасывает исключение
            ErrorsController.throwError(Errors.TEXTURE_DOES_NOT_EXIST, name);
        return sprites.get(name);
    }
    
}
