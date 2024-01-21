package app.gui.Swing.action;

import javax.swing.*;
import java.net.URL;

public abstract class AbstractRudokAction extends AbstractAction {

    public Icon LoadIcon(String fileName){
        URL imageURL= getClass().getResource(fileName);
        Icon icon=null;

        if(imageURL != null){
            icon= new ImageIcon(imageURL);
        }
        else{
            System.out.println("Resource not found: " + fileName);
        }
        return icon;
    }
}
