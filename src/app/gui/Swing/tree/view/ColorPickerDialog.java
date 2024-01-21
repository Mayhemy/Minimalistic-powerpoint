package app.gui.Swing.tree.view;

import app.gui.Swing.action.SetColorPotvrdiListener;
import app.gui.Swing.view.MainFrame;

import javax.swing.*;
import java.awt.*;

public class ColorPickerDialog extends JDialog {
    private JTextField txR;
    private JTextField txB;
    private JTextField txG;
    private JTextField txBorderWidth;
    private JTextField txBorderDashLength;
    private JComboBox<String> cb;
    public ColorPickerDialog() {
        super(MainFrame.getInstance(), true);
        setTitle("Promena boje slota");
        setSize(300, 400);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setLocationRelativeTo(MainFrame.getInstance());
        JPanel mainJP=new JPanel();
        mainJP.setLayout(new BoxLayout(mainJP, BoxLayout.PAGE_AXIS));
        JPanel compPanel=new JPanel();
        compPanel.setLayout(new GridLayout(5,2));
        JLabel tx1=new JLabel("Red Component: ", JLabel.CENTER);
        JLabel tx2=new JLabel("Blue Component: ",JLabel.CENTER);
        JLabel tx3=new JLabel("Green Component: ", JLabel.CENTER);
        txR=new JTextField();
        txB=new JTextField();
        txG=new JTextField();
        String[] choices = { "TextSlotHandler","MultimediaSlotHandler"};
        cb = new JComboBox<String>(choices);
        compPanel.add(tx1);
        compPanel.add(txR);
        compPanel.add(tx2);
        compPanel.add(txB);
        compPanel.add(tx3);
        compPanel.add(txG);
        JLabel txBorderWidthText=new JLabel("Border width",JLabel.CENTER);
        txBorderWidth=new JTextField();
        JLabel txBorderDashLengthText=new JLabel("Border dash length",JLabel.CENTER);
        txBorderDashLength=new JTextField();
        compPanel.add(txBorderWidthText);
        compPanel.add(txBorderWidth);
        compPanel.add(txBorderDashLengthText);
        compPanel.add(txBorderDashLength);
        mainJP.add(compPanel);
        JPanel panCommands=new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton potvrdiButton= new JButton("Potvrdi");
        panCommands.add(cb);
        potvrdiButton.addActionListener(new SetColorPotvrdiListener(this));
        panCommands.add(potvrdiButton);
        JTextArea tip=new JTextArea("Napravljeno je namerno da kada smo u bilo kom state-u osim add state-a i promenimo boju da se ne pamti kada predjemo u add state" +
                "(bilo je lakse ostaviti da se menja)" +
                "i takodje stavljeno da se menja za trenutno selektovan tab u project-viewu(skoro slicna implementacija ako treba da se menjaju ova podesavanja za " +
                "selektovani cvor u stablu(samo u kontroleru hvatati odredjeni cvor)");
        tip.setLineWrap(true);
        tip.setWrapStyleWord(true);
        mainJP.add(panCommands);
        mainJP.add(tip);
        add(mainJP);
        setVisible(true);
    }

    public String getR() {
        return txR.getText();
    }

    public String getB() {
        return txB.getText();
    }
    public String getG(){
        return txG.getText();
    }

    public String getBorderWidth() {
        return txBorderWidth.getText();
    }

    public String getBorderDashLength() {
        return txBorderDashLength.getText();
    }

    public JComboBox<String> getCb() {
        return cb;
    }
}