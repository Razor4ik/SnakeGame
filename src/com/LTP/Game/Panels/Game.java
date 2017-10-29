package com.LTP.Game.Panels;

import com.LTP.Game.Listeners.GameKeyListener;
import com.LTP.Game.Objects.Snake.Snake;
import com.LTP.Game.Objects.Snake.SnakePart;
import com.LTP.Game.Utils.Constants;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

//Отвечает за игровой процесс
public class Game extends JPanel implements ActionListener{
    
    private Timer t;
    private Snake snake;
    private GameKeyListener listener;
    
    public Game(){
        setSize(800, 600);
        t = new Timer(1000 / Constants.FPS, this);
        snake = new Snake();
        listener = new GameKeyListener(snake);
    }
    
    //Здесь происходит прорисовка
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for(SnakePart part : snake.getBody())
            g.drawImage(part.getSprite(), part.getX(), part.getY(), this);
    }
    
    //Регистрирует все лиснеры, позволяет слушать нажатия клавиш, а так же запускает таймер
    public void registerListeners(){
        addKeyListener(listener);
        setFocusable(true);
        grabFocus();
        t.restart();
    }
    
    //Останавливает таймер, и удаляет лиснеры, используется при смены панели
    public void removeListeners(){
        t.stop();
        removeKeyListener(listener);
    }
    
    //Двигает змею, а так же перерисовывает картинку
    @Override
    public void actionPerformed(ActionEvent e){
        snake.move();
        
        repaint();
    }
        
}
