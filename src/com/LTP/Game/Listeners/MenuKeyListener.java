package com.LTP.Game.Listeners;

import com.LTP.Game.Menu.MenuButtons;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//Отвечает за нажатия клавиш в меню
public class MenuKeyListener extends KeyAdapter{
    
    //Переход между пунктами меню и запуск выбранного пункта
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_UP){
            MenuButtons.previouseButton();
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            MenuButtons.nextButton();
        }else if(e.getKeyCode() == KeyEvent.VK_ENTER){
            MenuButtons.getSelected().run();
        }
    }
    
}
