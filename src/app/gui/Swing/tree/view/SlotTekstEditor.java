package app.gui.Swing.tree.view;

import app.gui.Swing.action.ItalicTextListener;
import app.gui.Swing.action.SlotTekstEditorListener;
import app.gui.Swing.action.UnderlineTextListener;
import app.gui.Swing.view.MainFrame;

import javax.swing.*;
import java.awt.*;

public class SlotTekstEditor extends JDialog{
    JTextPane field;
    SlotView slotView;
    public SlotTekstEditor(SlotView sv) {
        super(MainFrame.getInstance(), true);
        this.slotView=sv;
        field=new JTextPane();
        field.setText(slotView.getSlot().getContentWrap().getContent());
        setTitle("Editor Teksta slota");
        setSize(600, 350);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setLocationRelativeTo(MainFrame.getInstance());
        JPanel mainJP=new JPanel();
        mainJP.setLayout(new BoxLayout(mainJP, BoxLayout.PAGE_AXIS));
        JPanel panCommands=new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton italicButton=new JButton("italic");
        JButton underlineButton=new JButton("underline");
        JButton saveButton= new JButton("Save");
        italicButton.addActionListener(new ItalicTextListener(this));
        underlineButton.addActionListener(new UnderlineTextListener(this));
        saveButton.addActionListener(new SlotTekstEditorListener(this));
        panCommands.add(underlineButton);
        panCommands.add(italicButton);
        panCommands.add(saveButton);
        mainJP.add(field);
        mainJP.add(panCommands);
        /*JButton thumbsUpButton= new JButton("ThumbsUp");
        thumbsUpButton.addActionListener(new InfoThumbsUpActionListener());*/
        add(mainJP);
        setVisible(true);
    }

    public  JTextPane getField() {
        return field;
    }

    public void setField(JTextPane field) {
        this.field = field;
    }

    public SlotView getSlotView() {
        return slotView;
    }
}
