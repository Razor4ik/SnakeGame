package com.LTP.Game.Listeners;

import com.LTP.Game.Objects.Snake.Snake;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


//Отвечает за нажатия клавиш во время игры
public class GameKeyListener extends KeyAdapter{
    
    //Экземпляр класса змеи
    private final Snake snake;
    
    public GameKeyListener(Snake snake){
        this.snake = snake;
    }
    
    //В зависимости от нажатой клавиши, совершает поворот в ту или иную сторону
    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_UP && snake.getDirection() != 2 && snake.getDirection() != 0){
            snake.turn(0);
        }else if(key == KeyEvent.VK_RIGHT && snake.getDirection() != 3 && snake.getDirection() != 1){
            snake.turn(1);
        }else if(key == KeyEvent.VK_DOWN && snake.getDirection() != 0 && snake.getDirection() != 2){
            snake.turn(2);
        }else if(key == KeyEvent.VK_LEFT && snake.getDirection() != 1 && snake.getDirection() != 3){
            snake.turn(3);
        }
    }
    
}
