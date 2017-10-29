package com.LTP.Game.Objects.Snake;

import com.LTP.Game.Utils.Constants;
import com.LTP.Game.Utils.SpriteCutter;
import java.awt.Image;

//Не используемый на данный момент класс, просто наброски
public class StraighPart implements SnakePart{

    private int x, y, direction, length;
    private Image sprite;
    
    public StraighPart(int x, int y, int direction, int length, Image sprite){
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.sprite = sprite;
        this.length = length;
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
        if(direction == 0 || direction == 2)
            return "VerticalPart";
        
        return "HorisontalPart";
    }
    
    @Override
    public boolean update(int length, boolean change){
        
        if(length != 0){
            if(this.length + length <= 0)
                return false;
            
            if(change){                
                if(direction % 2 != 0)
                    x += (direction == 1 ? -Constants.STEP : Constants.STEP);
                else
                    y += (direction == 2 ? -Constants.STEP : Constants.STEP);
            }
            
            this.length += length;
            sprite = SpriteCutter.cutStandartSprite(getName(), this.length, direction);
        }
        return true;
    }
}
