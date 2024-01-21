package app.gui.Swing.action;

import app.Tree.Model.Prezentacija;
import app.gui.Swing.tree.model.MyTreeNode;
import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class CopyPrezentacijaAction extends AbstractRudokAction{
    public CopyPrezentacijaAction() {
        putValue(NAME, "Copy current prezentacija");
        putValue(SHORT_DESCRIPTION, "Copies current prezentacija to a selected project");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MyTreeNode x=(MyTreeNode)((EditPane) MainFrame.getInstance().getActivePane()).getMyJTree().getLastSelectedPathComponent();
        if(x.getNode() instanceof Prezentacija){
            ((EditPane) MainFrame.getInstance().getActivePane()).getWorkspaceView().setCopied((Prezentacija)x.getNode());
        }
    }
}
