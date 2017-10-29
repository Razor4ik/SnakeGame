package com.LTP.Game.Main;

import com.LTP.Game.Utils.Constants;
import com.LTP.Game.Panels.Menu;
import com.LTP.Game.Panels.Game;
import java.awt.CardLayout;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Главный класс
public class Start {
    
    private JFrame window;
    
    //Переключение между панелями работает на данном диспетчере компановки
    private static CardLayout layout;
    
    private static JPanel panel;
    private static Menu menu = new Menu();
    private static Game game;
    
    //Это просто костыль :)
    private static String previousePanel = null;
    
    private Start(){
        window = new JFrame(Constants.name);
        layout = new CardLayout();
        panel = new JPanel();
        panel.setLayout(layout);
        window.setSize(Constants.WIDTH, Constants.HEIGHT + 27);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.add(panel);
        window.setVisible(true);
        
        panel.add(menu, "Menu");
        panel.add(game, "Game");
        
        //Вывод меню на экран
        setPanel("Menu");
        
    }
    
    //Данный метод принимает одно из зарезервированных имен, а затем выводит ассоциируемую с этим именем панель
    public static void setPanel(String name){
        
        if(previousePanel != null){
            switch(previousePanel){
                case "Menu":
                    menu.removeListeners();
                    break;
                    
                case "Game":
                    game.removeListeners();
                    break;
            }
        }
        
        if(name.equals("Menu")){            
            layout.show(panel, "Menu");
            previousePanel = "Menu";
            menu.registerListeners();
        }else if(name.equals("Game")){            
            layout.show(panel, "Game");
            previousePanel = "Game";
            game.registerListeners();
        }
    }
    
    //Главный метод
    public static void main(String args[]){
        
        //Запускает контроллеры
        MainController.initControllers();
        
         game = new Game();
        
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new Start();
            }
        });
    }
    
}
