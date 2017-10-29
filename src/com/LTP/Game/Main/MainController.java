package com.LTP.Game.Main;

import com.LTP.Game.Utils.ErrorsController;
import com.LTP.Game.Utils.ImageController;
import com.LTP.Game.Utils.LocalizationController;
import javax.swing.JOptionPane;

//Контролирует все остальные контроллеры, основной класс в древе контроллеров
public class MainController {
    
    private MainController(){}
    
    //Метод инициирует работу всех остальных контроллеров
    public static void initControllers(){
        LocalizationController.init();
        ErrorsController.init();
        ImageController.loadAll();
    }
    
    
    //Данный метод принимает класс, который вызвал его, это требуется для определения дальнейших действий
    //Так же он имеет необязательный набор аргументов, который нужен для согласованной работы
    public static void use(Class user, String ...args){
        
        //Здесь обрабатываеться любая ошибка возникшая во время работы программы
        if(user.getSimpleName().equals("ErrorsController")){
            JOptionPane.showMessageDialog(null, args[1] + (args.length == 3 ? ": " + args[2] : ""), args[0], JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    
}
