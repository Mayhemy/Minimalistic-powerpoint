package app.gui.Swing.action;

import app.PrezEditSlideState.AbstractEditSlideState;
import app.gui.Swing.tree.view.PrezentacijaView;
import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditStateAddAction extends AbstractRudokAction {
    public EditStateAddAction() {
        putValue(NAME, "AddAction");
        putValue(SHORT_DESCRIPTION, "Edit+add state");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        (((EditPane) MainFrame.getInstance().getActivePane()).getWorkspaceView().getTrenutni().selektovanTab()).startAddSlotState();
    }
}
