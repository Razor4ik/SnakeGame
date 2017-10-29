package com.LTP.Game.Objects.Snake;

import com.LTP.Game.Utils.Constants;
import com.LTP.Game.Utils.SpriteCutter;
import java.awt.Image;

public class BentPart implements SnakePart{

    private int x, y, lengthX, lengthY, directionStart, directionEnd;
    private SnakePart previouse = null, next = null;
    private Image sprite;
    
    public BentPart(int x, int y, int lengthX, int lengthY, int directionStart, int directionEnd){
        this.x = x;
        this.y = y;
        this.lengthX = lengthX;
        this.lengthY = lengthY;
        this.directionStart = directionStart;
        this.directionEnd = directionEnd;
        
        sprite = SpriteCutter.cutBentSprite("Turn" + (directionStart > directionEnd ? directionEnd : directionStart) + "_" + (directionStart < directionEnd ? directionEnd : directionStart), lengthX, lengthY);
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
        return -1;
    }

    @Override
    public Image getSprite() {
        sprite = SpriteCutter.cutBentSprite("Turn" + (directionStart > directionEnd ? directionEnd : directionStart) + "_" + (directionStart < directionEnd ? directionEnd : directionStart), lengthX, lengthY);
        return sprite;
    }

    @Override
    public void move() {        
        previouse.move();
        next.move();
    }

    @Override
    public int getLength() {return -1;}

    @Override
    public String getName() {
        return "Turn" + (directionStart > directionEnd ? directionEnd : directionStart) + "_" + (directionStart < directionEnd ? directionEnd : directionStart);
    }

    @Override
    public boolean update(int length, boolean change){
        if(!previouse.update(-length, change))
            if(getLength(1) == 35){
                return false;
            }else{
                if(directionStart == 0 || directionStart == 2){
                    lengthY--;
                }else{
                    lengthX--;
                }
            }
        
        next.update(length, change);
        
        if(directionEnd == 3)
            next.move();
        
        return true;
        
    }
    
    public void update(SnakePart previouse, SnakePart next){
        this.previouse = previouse;
        this.next = next;
    }
    
    public int getLength(int number){
        if(number == 1)
            return (directionStart == 0 || directionStart == 2 ? lengthY : lengthX);
        
        return (directionEnd == 0 || directionEnd == 2 ? lengthY : lengthX);
    }
    
}
