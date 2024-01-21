package app.gui.Swing.view;

import app.gui.Swing.action.ActionManager;
import app.gui.Swing.action.MyWindowListener;
import app.gui.Swing.tree.view.SlideShowPane;

import java.awt.*;

import javax.swing.*;

public class MainFrame extends JFrame {
    private static MainFrame instance=null;
    private ActionManager actionManager;
    private MenuBar menuBar;
    private JPanel activePane;
    private MainFrame(){

    }
    private void initialise(){
        actionManager= new ActionManager();
        //activePane=EditPane.getInstance();
        activePane=EditPane.getInstance();
        initialiseGUI();
    }
    private void initialiseGUI(){
        Toolkit tk= Toolkit.getDefaultToolkit();
        Dimension screenSize= tk.getScreenSize();
        int windowHeight=screenSize.height/2;
        int windowWidth=screenSize.width/2;
        setSize(windowWidth,windowHeight);
        setLayout(new BorderLayout());
        menuBar=new MenuBar();
        setJMenuBar(menuBar);
        this.getContentPane().add(activePane);
        addWindowListener(new MyWindowListener());
    }
    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }
    public ActionManager getActionManager() {
        return actionManager;
    }

    public JPanel getActivePane() {
        return activePane;
    }


}
