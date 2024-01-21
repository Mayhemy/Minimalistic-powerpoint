package app.gui.Swing.action;

import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class EditStateMoveAction extends AbstractRudokAction{
    public EditStateMoveAction() {
        putValue(NAME, "MoveAction");
        putValue(SHORT_DESCRIPTION, "Edit+move state the target must be selected");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        (((EditPane) MainFrame.getInstance().getActivePane()).getWorkspaceView().getTrenutni().selektovanTab()).startMoveSlotState();
    }
}
