package app.gui.Swing.view;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MenuBar extends JMenuBar {
    public MenuBar (){
        JMenu fileMenu=new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        //JMenu miNew =new JMenu
        fileMenu.add((MainFrame.getInstance()).getActionManager().getNewProjectAction());
        fileMenu.add((MainFrame.getInstance()).getActionManager().getRemoveAction());
        JMenu helpMenu=new JMenu("Help");
        helpMenu.add((MainFrame.getInstance()).getActionManager().getEditAction());
        JMenu edit=new JMenu((MainFrame.getInstance()).getActionManager().getEditAction());
        edit.add((MainFrame.getInstance()).getActionManager().getPrezentacijaEditAction());

        add(fileMenu);
        add(helpMenu);
        add(edit);
    }

}
