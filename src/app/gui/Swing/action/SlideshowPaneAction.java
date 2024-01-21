package app.gui.Swing.action;


import app.Tree.Model.Prezentacija;
import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class SlideshowPaneAction extends AbstractRudokAction {
    public SlideshowPaneAction() {
        putValue(NAME, "Slideshow Mode");
        putValue(SHORT_DESCRIPTION, "Slideshow pane mode of viewing");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object z= ((EditPane)MainFrame.getInstance().getActivePane()).getMyJTree().getLastSelectedPathComponent();
        if(z instanceof Prezentacija){

        }
        ((EditPane)MainFrame.getInstance().getActivePane()).getWorkspaceView().getTrenutni().selektovanTab().startSlideshowPaneState();
    }
}