package app.command;

import app.Tree.Model.RuNode;
import app.Tree.Model.RuNodeComp;
import app.gui.Swing.tree.model.MyTreeNode;
import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import javax.swing.*;

public class RemoveCommand extends AbstractCommand {
    MyTreeNode myTreeNode;
    RuNode node;
    MyTreeNode parent;
    boolean postoji;

    public RemoveCommand(MyTreeNode myTreeNode, boolean postoji) {
        this.myTreeNode = myTreeNode;
        this.postoji = postoji;
    }

    @Override
    public void doCommand() {
        parent=(MyTreeNode)myTreeNode.getParent();
        node=myTreeNode.getNode();
        myTreeNode.removeChild();
        /*TreeNode dete1 = ((TreeNode) myTreeNodeParent).getChildAt(((TreeNode) myTreeNodeParent).getChildCount() - 1);
        ((MyTreeNode) dete1).removeChild();*/
        SwingUtilities.updateComponentTreeUI(((EditPane) (MainFrame.getInstance()).getActivePane()).getMyJTree());
    }

    @Override
    public void undoCommand() {
        parent.addChild(myTreeNode);
        ((RuNodeComp)parent.getNode()).addChild(node);
        SwingUtilities.updateComponentTreeUI(((EditPane) (MainFrame.getInstance()).getActivePane()).getMyJTree());
    }
}
