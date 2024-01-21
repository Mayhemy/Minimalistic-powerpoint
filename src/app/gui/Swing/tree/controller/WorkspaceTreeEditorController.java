/*package app.gui.Swing.tree.controller;

import app.Tree.Model.Workspace.Project;
import app.Tree.Model.Workspace.Slajd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class WorkspaceTreeEditorController implements ActionListener {

    Object stavka;

    public WorkspaceTreeEditorController(Object stavka) {
        //TODO :)
        this.stavka = stavka;
    }

    public boolean isCellEditable(EventObject arg0) {
        if (arg0 instanceof MouseEvent)
            if (((MouseEvent) arg0).getClickCount() == 3) {
                return true;
            }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (stavka instanceof Project) {
            ((Project) stavka).setName(e.getActionCommand());
        } else {
            ((Slajd) stavka).setName(e.getActionCommand());
        }
    }
}
*/