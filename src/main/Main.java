package main;


import app.gui.Swing.view.MainFrame;

public class Main {

    public static void main(String[] args) {
        MainFrame b = MainFrame.getInstance();
        b.setLocationRelativeTo(null);
        b.setVisible(true);
    }
}
