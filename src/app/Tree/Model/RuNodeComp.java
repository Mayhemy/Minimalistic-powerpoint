package app.Tree.Model;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public abstract class RuNodeComp extends RuNode implements Serializable {
    public List<RuNode> children=new LinkedList<>();

    public RuNodeComp(){

    }

    public RuNodeComp(String name, RuNode parent) {
        super(name, parent);
    }

    public void addChildren(List<RuNode> lista){};
    public void removeChildren(List<RuNode> lista){};

    public List<RuNode> getChildren() {
        return children;
    }

    public RuNodeComp(RuNode parent){
        super(parent);
    }

    public void setDeca(List<RuNode> deca) {
        this.children = deca;
        notifySubscribers(this);
    }

    public void addChild(RuNode dete){
        children.add(dete);
        if(dete instanceof Project)
            dete.setName("Projekat"+((Project) dete).getBrojac());
        else if(dete instanceof Prezentacija){
            dete.setName("Prezentacija");
            dete.addSubscriber((Project)this);
        }else if(dete instanceof Slajd){
            dete.setName("Slajd");
            dete.addSubscriber((Project)this.getParentNode());
        }
        //dete.setParentNode(this);
        notifySubscribers(this);
        System.out.println("Dodao sam dete "+dete+" roditelj:"+name+"        ");
    }
    public int getChildCount(){
        return children.size();
    }
    public RuNode getChildAt(int index){
        return children.get(index);
    }
    public void removeChild(RuNode node){
        children.remove(node);
        //node.setParentNode(null);
        node=null;
        notifySubscribers(this);
    };
    public int getIndexOf(RuNode node){
        int pos=0;
        for(RuNode n:children){
            if(n.getName().equals(node.getName()) /*&& n.getParentNode().equals(node.getParentNode())*/){
                return pos;
            }
        }
        pos++;
        return -1;
    }
   /* @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RuNodeComp prosledjeni = (RuNodeComp) obj;
        return name.equals(prosledjeni.name) &&  parent.equals(prosledjeni.parent) && children.equals(prosledjeni.children);
    }*/
}
