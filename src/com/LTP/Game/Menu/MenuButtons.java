package com.LTP.Game.Menu;

import com.LTP.Game.Main.Start;

//Отвечает за кнопки конкретно в меню
public class MenuButtons {
    
    private static GameButton buttons[] = new GameButton[4];
    
    //Инициализация всех кнопок, а так же ассоциация неких действий
    public MenuButtons(){
        for(int y = 100, counter = 0; y < 500; y += 100, counter++){
            switch (counter) {
                case 0:
                    buttons[counter] = new GameButton(300, y, "New Game", new Runnable(){
                        @Override
                        public void run(){
                            Start.setPanel("Game");
                        }
                    }); 
                    break;
                case 1:
                    buttons[counter] = new GameButton(300, y, "Stat", new Runnable(){
                        @Override
                        public void run(){
                            
                        }
                    }); 
                    break;
                case 2:
                    buttons[counter] = new GameButton(300, y, "Settings", new Runnable(){
                        @Override
                        public void run(){
                            
                        }
                    }); 
                    break;
                case 3:
                    buttons[counter] = new GameButton(300, y, "Exit", new Runnable(){
                        @Override
                        public void run(){
                            System.exit(0);
                        }
                    }); 
                    break;
            }
        }
        
        //Автоматически выбирает первую кнопку (Новая игра)
        buttons[0].blink();
    }
    
    public GameButton[] getButtons(){
        return buttons;
    }
    
    //Возвращает выбранную в данный момент кнопку
    public static GameButton getSelected(){
        for(GameButton button : buttons)
            if(button.isSelected())
                return button;
        throw new RuntimeException();
    }
    
    //"Отпускает" текущую кнопку и "Нажимает" следующую
    public static void nextButton(){
        int index = 0;
        
        for(index = 0; index < 4; index++)
            if(buttons[index].isSelected())
                break;
        
        if(index != 3){
            buttons[index].blink();
            buttons[index + 1].blink();
        }else{
            buttons[3].blink();
            buttons[0].blink();
        }
            
    }
    
    //Противоположное действие предидущего метода
    public static void previouseButton(){
        int index = 0;
        
        for(index = 0; index < 4; index++)
            if(buttons[index].isSelected())
                break;
        
        if(index != 0){
            buttons[index].blink();
            buttons[index - 1].blink();
        }else{
            buttons[0].blink();
            buttons[3].blink();
        }
    }
    
}
