package app.command;

import app.Error.ErrorFactory;
import app.NewNodeFactoryMethod.AbstractNodeFactory;
import app.NewNodeFactoryMethod.NodeFactoryGenerator;
import app.Tree.Model.RuNode;
import app.gui.Swing.tree.model.MyTreeNode;
import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import javax.swing.*;
import javax.swing.tree.TreeNode;

public class AddCommand extends AbstractCommand {
    MyTreeNode myTreeNodeParent;
    RuNode node;
    MyTreeNode dete;
    boolean postoji;

    public AddCommand(MyTreeNode myTreeNode, boolean postoji) {
        this.myTreeNodeParent = myTreeNode;
        this.postoji = postoji;
    }

    @Override
    public void doCommand() {
        if(postoji){
            node.setParentNode(myTreeNodeParent.getNode());
            //MyTreeNode dete=new MyTreeNode(node);
            myTreeNodeParent.addChild(dete);
        }
        if (!postoji){
            AbstractNodeFactory f = NodeFactoryGenerator.returnNodeFactory(myTreeNodeParent);
            if(f==null){
                ErrorFactory.getInstance().baciError("ErrorSlideChild");
            }else {
                node=f.getNFT(myTreeNodeParent.getNode());
                dete = new MyTreeNode(node);
                myTreeNodeParent.addChild(dete);
            }
        }
        postoji=true;
        SwingUtilities.updateComponentTreeUI(((EditPane)(MainFrame.getInstance()).getActivePane()).getMyJTree());
    }

    @Override
    public void undoCommand() {
        TreeNode dete1=((TreeNode)myTreeNodeParent).getChildAt(((TreeNode)myTreeNodeParent).getChildCount()-1);
        ((MyTreeNode)dete1).removeChild();
        SwingUtilities.updateComponentTreeUI(((EditPane)(MainFrame.getInstance()).getActivePane()).getMyJTree());
    }
}
