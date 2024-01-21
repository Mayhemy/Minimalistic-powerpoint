package app.gui.Swing.action;

import app.Tree.Model.Slot;
import app.gui.Swing.tree.view.SlotSlikaChooser;
import app.gui.Swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlotMultimediaEditorListener implements ActionListener {
    Slot s;
    public SlotMultimediaEditorListener(Slot s) {
        this.s=s;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SlotSlikaChooser chooser=new SlotSlikaChooser();
        int returnVal = chooser.showOpenDialog(MainFrame.getInstance());
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this directory: " +
                    chooser.getSelectedFile().getAbsolutePath());
            s.getContentWrap().setContent(chooser.getSelectedFile().getAbsolutePath());
        }
    }
}
