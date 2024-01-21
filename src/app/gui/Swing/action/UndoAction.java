package app.gui.Swing.action;

import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class UndoAction extends AbstractRudokAction {
    public UndoAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        putValue(NAME, "Undo");
        putValue(SHORT_DESCRIPTION, "Undo last action");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ((EditPane) MainFrame.getInstance().getActivePane()).getCmdManager().undoCommand();
    }
}
