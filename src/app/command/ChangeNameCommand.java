package app.command;

import app.Tree.Model.RuNode;
import app.gui.Swing.tree.model.MyTreeNode;
import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import javax.swing.*;

public class ChangeNameCommand extends AbstractCommand {
    MyTreeNode myTreeNode;
    RuNode node;
    MyTreeNode parent;
    boolean postoji;
    String newName;
    String oldName;

    public ChangeNameCommand(MyTreeNode myTreeNode, boolean postoji,String newName) {
        this.myTreeNode = myTreeNode;
        this.postoji = postoji;
        this.oldName=myTreeNode.getNode().getName();
        this.newName=newName;
    }

    @Override
    public void doCommand() {
        myTreeNode.getNode().setName(newName);
        /*TreeNode dete1 = ((TreeNode) myTreeNodeParent).getChildAt(((TreeNode) myTreeNodeParent).getChildCount() - 1);
        ((MyTreeNode) dete1).removeChild();*/
        SwingUtilities.updateComponentTreeUI(((EditPane) (MainFrame.getInstance()).getActivePane()).getMyJTree());
    }

    @Override
    public void undoCommand() {
        myTreeNode.getNode().setName(oldName);
        SwingUtilities.updateComponentTreeUI(((EditPane) (MainFrame.getInstance()).getActivePane()).getMyJTree());
    }
}