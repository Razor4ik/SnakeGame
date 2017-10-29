package com.LTP.Game.Utils;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class SpriteCutter {
    
    private SpriteCutter(){}
    
    public static Image cutStandartSprite(String name, int length, int direction){
        
        Image result = null;
        
        switch(direction){
            case 0:
                result = new BufferedImage(50, length, BufferedImage.TYPE_INT_ARGB);
                
                for(int n = ((length - (length % 50)) / 50 ); n > 0 ; n--)
                    result.getGraphics().drawImage(ImageController.get(name), 0, n * 50 - (50 - (length % 50)), null);

                if((length % 50) != 0)
                    result.getGraphics().drawImage(((BufferedImage)ImageController.get(name)).getSubimage(0, 0, 50, (length % 50)), 0, 0, null);
                break;
                
            case 1:
                
                result = new BufferedImage(length, 50, BufferedImage.TYPE_INT_ARGB);
                
                for(int n = ((length - (length % 50)) / 50 ); n > 0 ; n--)
                    result.getGraphics().drawImage(ImageController.get(name), n * 50 - (50 - (length % 50)), 0, null);
                
                if((length % 50) != 0)
                    result.getGraphics().drawImage(((BufferedImage)ImageController.get(name)).getSubimage(0, 0, (length % 50), 50), 0, 0, null);
                break;
                
            case 2:
                
                result = new BufferedImage(50, length, BufferedImage.TYPE_INT_ARGB);
                
                for(int n = 0; n < ((length - (length % 50)) / 50 ); n++)
                    result.getGraphics().drawImage(ImageController.get(name), 0, n * 50, null);
                
                if((length % 50) != 0)
                    result.getGraphics().drawImage(((BufferedImage)ImageController.get(name)).getSubimage(0, 50 - (length % 50), 50, length % 50), 0, length - (length % 50), null);
                break;
             
            case 3:
                
                result = new BufferedImage(50, length, BufferedImage.TYPE_INT_ARGB);
                
                for(int n = 0; n < ((length - (length % 50)) / 50 ); n++)
                    result.getGraphics().drawImage(ImageController.get(name), n * 50, 0, null);
                
                if((length % 50) != 0)
                    result.getGraphics().drawImage(((BufferedImage)ImageController.get(name)).getSubimage(50 - (length % 50), 0, length % 50, 50), length - (length % 50), 0, null);
                break;
        }
        
        return result;
    }
    
    public static Image cutBentSprite(String name, int lengthX, int lengthY){
        Image result = new BufferedImage(lengthX, lengthY, BufferedImage.TYPE_INT_ARGB);
        
        if(name.equals("Turn0_1")){
            return ((BufferedImage)ImageController.get(name)).getSubimage(0, 0, lengthX, lengthY);
        }else if(name.equals("Turn0_3")){
            return ((BufferedImage)ImageController.get(name)).getSubimage(0, 50 - lengthY, lengthX, lengthY);
        }else if(name.equals("Turn1_2")){
            return ((BufferedImage)ImageController.get(name)).getSubimage(50 - lengthX, 0, lengthX, lengthY);
        }else if(name.equals("Turn2_3")){
            return ((BufferedImage)ImageController.get(name)).getSubimage(0, 0, lengthX, lengthY);
        }
        
        return result;
    }
    
}
