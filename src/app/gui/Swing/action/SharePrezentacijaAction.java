package app.gui.Swing.action;

import app.Tree.Model.Prezentacija;
import app.Tree.Model.Project;
import app.Tree.Model.RuNode;
import app.Tree.Model.RuNodeComp;
import app.gui.Swing.tree.model.MyTreeNode;
import app.gui.Swing.tree.view.PrezentacijaView;
import app.gui.Swing.tree.view.ProjectView;
import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SharePrezentacijaAction extends AbstractRudokAction {
    public SharePrezentacijaAction() {
        putValue(NAME, "Share current prezentacija");
        putValue(SHORT_DESCRIPTION, "Shares a current prezentacija to a selected project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyTreeNode x=(MyTreeNode)((EditPane) MainFrame.getInstance().getActivePane()).getMyJTree().getLastSelectedPathComponent();
        if(x.getNode() instanceof Project){
            addInorder(((EditPane) MainFrame.getInstance().getActivePane()).getWorkspaceView().getCopied(),x);
            ((Project) x.getNode()).addChild(((EditPane) MainFrame.getInstance().getActivePane()).getWorkspaceView().getCopied());
        }
        //if(x.getNode() instanceof Project){
            //x.addChild(new MyTreeNode(trenutna));
           // ((Project) x.getNode()).addChild(trenutna);
        //}
        SwingUtilities.updateComponentTreeUI(((EditPane)MainFrame.getInstance().getActivePane()).getMyJTree());
    }
    void addInorder(RuNode p, MyTreeNode parent) {
        if (!(p instanceof RuNodeComp)) {
            MyTreeNode dete = new MyTreeNode(p);
            parent.addChild(dete);
            return;
        }
        // Total children count

        int total = ((RuNodeComp) p).getChildren().size();
        MyTreeNode dete = new MyTreeNode(p);
        // All the children except the last
        for (int i = 0; i <= total - 1; i++)
            addInorder(((RuNodeComp) (p)).getChildren().get(i), dete);

        // Print the current node's data
        parent.addChild(dete);
        // Last child
        /*if(((RuNodeComp) (p)).getChildren().size()!=0)
            addInorder(((RuNodeComp) (p)).getChildren().get(total - 1), dete);*/
    }
}
