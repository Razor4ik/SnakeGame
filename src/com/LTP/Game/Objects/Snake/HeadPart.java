package com.LTP.Game.Objects.Snake;

import com.LTP.Game.Utils.Constants;
import com.LTP.Game.Utils.SpriteCutter;
import java.awt.Image;

//Описывает голову змеии
public class HeadPart implements SnakePart{

    private int x, y, direction, length;
    private Image sprite;
    
    public HeadPart(int x, int y, int direction, int length){
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.length = length;
        sprite = SpriteCutter.cutStandartSprite("End" + direction, length, direction);
    }
    
    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getDirection() {
        return direction;
    }

    @Override
    public Image getSprite() {
        return sprite;
    }

    @Override
    public void move() {
        if(direction % 2 != 0)
            x += (direction == 1 ? Constants.STEP : -Constants.STEP);
        else
            y += (direction == 2 ? Constants.STEP : -Constants.STEP);
    }
    
    @Override
    public int getLength(){
        return length;
    }
    
    @Override
    public String getName(){
        return "End" + direction;
    }
    
    @Override
    public boolean update(int length, boolean change){
        if(this.length + length < 10 || this.length + length > 50)
            return false;
        
        if(change)
            if(direction % 2 != 0)
                x += (direction == 1 ? -Constants.STEP : Constants.STEP);
            else
                y += (direction == 2 ? -Constants.STEP : Constants.STEP);
            
        this.length += length;
        sprite = SpriteCutter.cutStandartSprite(getName(), this.length, direction);
        
        return true;
    }
    
    public void turn(int direction, int length){
        switch(direction){
            case 0:
                
                break;
                
            case 1:
                x += length;
                break;
                
            case 2:
                
                break;
                
            case 3:
                x -= length;
                break;
        }
        
        this.direction = direction;
        
        update(-(this.length - length), false);
    }
    
}
