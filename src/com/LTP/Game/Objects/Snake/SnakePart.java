package com.LTP.Game.Objects.Snake;

import java.awt.Image;

//Данный интерфейс является шаблоном для частей змеи
public interface SnakePart {
    
    public int getX();
    public int getY();
    public int getDirection();
    public Image getSprite();
    public void move();
    public int getLength();
    public String getName();
    public boolean update(int length, boolean change);
    
}
