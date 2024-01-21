package app.gui.Swing.action;

import app.gui.Swing.tree.view.SlotSlikaChooser;
import app.gui.Swing.tree.view.SlotSlikaEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlikaEditorPotvrdiListener implements ActionListener {
    SlotSlikaEditor SSE;
    public SlikaEditorPotvrdiListener(SlotSlikaEditor sse) {
        this.SSE=sse;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SSE.setVisible(false);
    }
}
