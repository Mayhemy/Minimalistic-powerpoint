package app.gui.Swing.view;

import app.gui.Swing.action.InfoOkActionListener;

import javax.swing.*;
import java.awt.*;

public class InfoDialog extends JDialog {
    private static InfoDialog instance =null;

    private InfoDialog() {
        super(MainFrame.getInstance(), true);
    }
    private void initialise(){
        instance.setTitle("Info");
        instance.setSize(600, 350);
        instance.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        instance.setLocationRelativeTo(MainFrame.getInstance());
        JPanel mainJP=new JPanel();
        mainJP.setLayout(new BoxLayout(mainJP, BoxLayout.PAGE_AXIS));
        JLabel lb1=new JLabel(new ImageIcon(getClass().getResource("images/jedina.jpg")));
        JLabel tx1=new JLabel("Ime: Feđa");
        JLabel tx2=new JLabel("Prezime: Filipović");
        JLabel tx3=new JLabel("Broj indeksa: 116/20 RN");
        mainJP.add(tx1);
        mainJP.add(tx2);
        mainJP.add(tx3);
        mainJP.add(lb1);
        JPanel panCommands=new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton okButton= new JButton("OK");
        okButton.addActionListener(new InfoOkActionListener());
        panCommands.add(okButton);
        mainJP.add(panCommands);
        /*JButton thumbsUpButton= new JButton("ThumbsUp");
        thumbsUpButton.addActionListener(new InfoThumbsUpActionListener());*/
        add(mainJP);

    }
    public static InfoDialog getInstance(){
        if (instance == null) {
            instance = new InfoDialog();
            instance.initialise();
        }
        return instance;
    }
    public void ugasi(){
        setVisible(false);
    }
}
