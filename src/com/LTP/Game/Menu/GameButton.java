package com.LTP.Game.Menu;

import com.LTP.Game.Utils.ImageController;
import java.awt.Image;

//Отвечает за все нарисованные кнопки в программе
public class GameButton {
    
    private boolean selected = false;
    
    //Имя кнопки
    private String name;
    
    //Координаты кнопки
    private int x;
    private int y; 
    
    //Здесь хранится код, который выполнится если кнопка будит нажата
    private Runnable runnable;
    
    public GameButton(int x, int y, String name, Runnable runnable){
        this.x = x;
        this.y = y;
        this.runnable = runnable;
        this.name = name;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public boolean isSelected(){
        return selected;
    }
    
    //Метод "Нажимает" / "Отпускает" кнопку
    public void blink(){
        x += (selected ? 10 : -10);
        y += (selected ? 10 : -10);
        
        selected = !selected;
    }
    
    //Возвращает текстуру кнопки
    public Image getSprite(){       
        return ImageController.get(name + (isSelected() ? "_big" : ""));
    }
    
    //Выполняет действие, ассоциированное с кнопкой
    public void run(){
        runnable.run();
    }
    
}
