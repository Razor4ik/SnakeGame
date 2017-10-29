package com.LTP.Game.Objects.Snake;

import com.LTP.Game.Utils.SpriteCutter;
import java.util.List;
import java.util.ArrayList;

//Сама змея
public class Snake {
    
    private int direction = 0;
    
    //Тело, которое состоит из SnakePart'ов
    private List<SnakePart> body = new ArrayList<>();
    
    private boolean isMooving = true;
    
    public Snake(){        
        body.add(new HeadPart(200, 200, direction, 50));
        body.add(new StraighPart(200, 250, direction, 200, SpriteCutter.cutStandartSprite((direction == 0 || direction == 2 ? "VerticalPart" : "HorisontalPart"), 200, direction)));
        body.add(new TailPart(200, 450, direction, 50));
    }
    
    public void move(){
        
        if(!isMooving)
            return;
        
        for(int d = 0; d < body.size(); d++){
            SnakePart part = body.get(d);
            
            if(body.size() > d + 1 && body.get(d + 1) instanceof BentPart){
                if(!body.get(d + 1).update(1, false)){
                    if(d != body.size() - 3){
                        body.remove(d + 2);
                        ((BentPart)body.get(d + 1)).update(body.get(d + 2), part);
                        d++; 
                        continue;
                    }else{
                        int length = ((BentPart)body.get(d + 1)).getLength(1);
                        body.remove(d + 1);
                        ((TailPart)body.get(body.size() - 1)).turn(part.getDirection(), 50, length);
                        break;
                    }
                }
                
                d += 2;
                continue;
            }
            
            part.move();
        }
    }
    
    public void turn(int direction){
       HeadPart head = (HeadPart)body.get(0);
       
       BentPart bentPart = new BentPart(head.getX(), head.getY(), 50, 50, this.direction, direction);
       
       int x = bentPart.getX() + (direction == 1 ? 50 : direction == 3 ? -1 : 0);
       int y = bentPart.getY() + (direction == 0 ? -1 : direction == 2 ? 50 : 0);
       
       body.add(1, new StraighPart(x, y, direction, 1, SpriteCutter.cutStandartSprite(direction == 0 || direction == 2 ? "VerticalPart" : "HorisontalPart", 1, direction)));
       
       SnakePart previouse = body.get(2);
       
       bentPart.update(previouse, body.get(1));
       
       head.turn(direction, bentPart.getLength(2));
       
       body.add(2, bentPart);
       
       this.direction = direction;
       
       //isMooving = false;
       
    }
    
    public int getDirection(){
        return direction;
    }
    
    public List<SnakePart> getBody(){
        return body;
    }
    
}
