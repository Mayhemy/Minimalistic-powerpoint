package app.gui.Swing.action;

import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class EditStateDeleteAction extends AbstractRudokAction{
    public EditStateDeleteAction() {
        putValue(NAME, "DeleteAction");
        putValue(SHORT_DESCRIPTION, "Edit+delete state");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        (((EditPane) MainFrame.getInstance().getActivePane()).getWorkspaceView().getTrenutni().selektovanTab()).startDeleteSlotState();
    }
}
