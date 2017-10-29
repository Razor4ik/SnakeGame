package com.LTP.Game.Panels;

import com.LTP.Game.Listeners.MenuKeyListener;
import com.LTP.Game.Menu.GameButton;
import com.LTP.Game.Menu.MenuButtons;
import com.LTP.Game.Utils.Constants;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

//Отвечает за работу меню игры
public class Menu extends JPanel implements ActionListener{
    
    private MenuButtons mb = new MenuButtons();
    private Timer t = new Timer(1, this);
    
    private MenuKeyListener listener = new MenuKeyListener();
    
    public Menu(){
        super();
        
        setSize(Constants.WIDTH, Constants.HEIGHT);
    }
    
    //Здесь происходит прорисовка меню
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for(GameButton button : mb.getButtons()){
            g.drawImage(button.getSprite(), button.getX(), button.getY(), this);
        }
    }
    
    //Активирует все лиснеры, позволяет прослушивать нажатия клавиш, а так же запускает таймер
    public void registerListeners(){
        addKeyListener(listener);
        setFocusable(true);
        grabFocus();
        t.restart();
    }
    
    //Останавливает работу меню, метод используеться для перехода на другую панель
    public void removeListeners(){
        t.stop();
        removeKeyListener(listener);
    }
    
    //Метод просто перерисовывает меню каждую 1/1000 секунды
    @Override
    public void actionPerformed(ActionEvent e){     
        repaint();
    }
    
}
