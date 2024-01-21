package app.gui.Swing.view;

import javax.swing.*;

public class Toolbar extends JToolBar {
    public Toolbar() {
        setFloatable(false);
        add((MainFrame.getInstance()).getActionManager().getNewProjectAction());
        add((MainFrame.getInstance()).getActionManager().getInfoAction());
        add((MainFrame.getInstance()).getActionManager().getPrezentacijaEditAction());
        add((MainFrame.getInstance()).getActionManager().getRemoveAction());
        add((MainFrame.getInstance()).getActionManager().getUndoAction());
        add((MainFrame.getInstance()).getActionManager().getRedoAction());
        add((MainFrame.getInstance()).getActionManager().getSaveAction());
        add((MainFrame.getInstance()).getActionManager().getSaveAsAction());
        add((MainFrame.getInstance()).getActionManager().getOpenProjectAction());
        add((MainFrame.getInstance()).getActionManager().getCopyPrezentacijaAction());
        add((MainFrame.getInstance()).getActionManager().getSharePrezentacijaAction());
        this.addSeparator();

    }
}
