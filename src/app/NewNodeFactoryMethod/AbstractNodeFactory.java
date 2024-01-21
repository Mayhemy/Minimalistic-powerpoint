package app.NewNodeFactoryMethod;

import app.Tree.Model.RuNode;

public abstract class AbstractNodeFactory {
    public RuNode getNFT(RuNode selected){
        RuNode n=createNode();
        n.setParentNode(selected);
        //n.setName("SDADSADSADAS");
        return n;
    }
    protected abstract RuNode createNode();
}
