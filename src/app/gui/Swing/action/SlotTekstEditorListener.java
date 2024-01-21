package app.gui.Swing.action;

import app.gui.Swing.tree.view.SlotTekstEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlotTekstEditorListener implements ActionListener {
    SlotTekstEditor STE;
    public SlotTekstEditorListener(SlotTekstEditor s) {
        this.STE=s;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        STE.getSlotView().getHandler().setContent(STE.getField().getText());
        STE.setVisible(false);
    }
}
