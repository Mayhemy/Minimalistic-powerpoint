package app.gui.Swing.action;

import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitSlideshowListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ((EditPane)MainFrame.getInstance().getActivePane()).getWorkspaceView().getTrenutni().selektovanTab().startEditPaneState();
        ((EditPane) MainFrame.getInstance().getActivePane()).getWorkspaceView().getTrenutni().selektovanTab().play();
    }
}
