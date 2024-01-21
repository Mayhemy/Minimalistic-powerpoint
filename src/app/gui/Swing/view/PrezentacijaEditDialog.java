package app.gui.Swing.view;

import app.gui.Swing.action.PrezentacijaEditDialogPotvrdiListener;

import javax.swing.*;
import java.awt.*;

public class PrezentacijaEditDialog extends JDialog{
    private JTextField tx3;
    private JTextField tx4;
    public PrezentacijaEditDialog() {
        super(MainFrame.getInstance(), true);
        setTitle("Promena imena autora i slike");
        setSize(300, 200);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setLocationRelativeTo(MainFrame.getInstance());
        JPanel mainJP=new JPanel();
        mainJP.setLayout(new BoxLayout(mainJP, BoxLayout.PAGE_AXIS));
        JPanel compPanel=new JPanel();
        compPanel.setLayout(new GridLayout(2,2));
        JLabel tx1=new JLabel("Ime: ", JLabel.CENTER);
        JLabel tx2=new JLabel("Slika:",JLabel.CENTER);
        tx3=new JTextField();
        tx4=new JTextField();
        compPanel.add(tx1);
        compPanel.add(tx3);
        compPanel.add(tx2);
        compPanel.add(tx4);
        mainJP.add(compPanel);
        JPanel panCommands=new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton potvrdiButton= new JButton("Potvrdi");
        potvrdiButton.addActionListener(new PrezentacijaEditDialogPotvrdiListener(this));
        panCommands.add(potvrdiButton);
        mainJP.add(panCommands);
        add(mainJP);
        setVisible(true);
    }

    public String getAutor() {
        return tx3.getText();
    }

    public String getSlika() {
        return tx4.getText();
    }

}
