package app.gui.Swing.action;

import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class EditPaneAction extends AbstractRudokAction {
    public EditPaneAction() {
        putValue(NAME, "Edit Mode");
        putValue(SHORT_DESCRIPTION, "Edit pane mode of viewing");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ((EditPane)MainFrame.getInstance().getActivePane()).getWorkspaceView().getTrenutni().selektovanTab().startEditPaneState();
    }
}
