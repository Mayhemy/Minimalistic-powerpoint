package app.gui.Swing.tree.model;

import app.Tree.Model.RuNode;
import app.Tree.Model.RuNodeComp;
import app.Tree.Model.Workspace;

import javax.swing.tree.DefaultMutableTreeNode;

public class MyTreeNode extends DefaultMutableTreeNode {
    private RuNode node;

    public MyTreeNode() {
        this.node=new Workspace("Workspace",null);
    }
    public MyTreeNode(RuNode mojNode){
        this.node=mojNode;
    }

    public RuNode getNode() {
        return node;
    }

    public void setNode(RuNode node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return node.getName();
    }

    /*public void addChild(RuNode child){
        super.add(new MyTreeNode(child));
        ((RuNodeComp)node).addChild(child);
    }*/
    public void addChild(MyTreeNode child){
        super.add(child);
    }
    public void removeChild(){
        super.removeFromParent();
        ((RuNodeComp)node.getParentNode()).removeChild(node);
    }

}
