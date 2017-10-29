package com.LTP.Game.Objects.Snake;

import com.LTP.Game.Utils.Constants;
import com.LTP.Game.Utils.SpriteCutter;
import java.awt.Image;

//Описывает хвост змеи
public class TailPart implements SnakePart{

    private int x, y, direction, length;
    private Image sprite;
    
    public TailPart(int x, int y, int direction, int length){
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.length = length;
        sprite = SpriteCutter.cutStandartSprite("End" + (direction - 2 < 0 ? direction + 2 : direction - 2), length, (direction - 2 < 0 ? direction + 2 : direction - 2));
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
        return "End" + (direction - 2 < 0 ? direction + 2 : direction - 2);
    }
    
    @Override
    public boolean update(int length, boolean change){
        if(this.length + length < 1 || this.length + length > 50)
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
    
    public void turn(int direction, int length, int change){
        switch(direction){
            case 0:
                
                break;
                
            case 1:
                y -= (this.direction == 0 ? change : -change);
                break;
                
            case 2:
                
                break;
                
            case 3:
                y -= (this.direction == 0 ? change : -change);
                break;
        }
        this.direction = direction;
        update(-(this.length - length), false);
    }
    
}
