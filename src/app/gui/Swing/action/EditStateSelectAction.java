package app.gui.Swing.action;

import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class EditStateSelectAction extends AbstractRudokAction{
    public EditStateSelectAction() {
        putValue(NAME, "SelectAction");
        putValue(SHORT_DESCRIPTION, "Edit+select state, used for selecting slideView component(Slot)");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        (((EditPane) MainFrame.getInstance().getActivePane()).getWorkspaceView().getTrenutni().selektovanTab()).startSelectSlotState();
    }
}
