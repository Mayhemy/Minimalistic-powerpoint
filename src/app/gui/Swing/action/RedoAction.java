package app.gui.Swing.action;

import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RedoAction extends AbstractRudokAction{
    public RedoAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(NAME, "Redo");
        putValue(SHORT_DESCRIPTION, "Redo last action");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ((EditPane)MainFrame.getInstance().getActivePane()).getCmdManager().doCommand();
    }
}
