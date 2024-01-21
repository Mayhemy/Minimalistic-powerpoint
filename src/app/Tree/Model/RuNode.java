package app.Tree.Model;

import app.Observer.Publisher;
import app.Observer.Subscriber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class RuNode implements Publisher, Serializable {
    String name;
    RuNode parent;
    transient List<Subscriber> subscribers;
    public RuNode(){

    }
    public RuNode(String name, RuNode parent) {
        this.name = name;
        this.parent = parent;
    }
    public RuNode(RuNode parent){
        this.parent=parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String ime){
        this.name=ime;
        notifySubscribers(this);
    }

    public RuNode getParentNode() {
        return parent;
    }

    public void setParentNode(RuNode parent) {
        this.parent = parent;
        ((RuNodeComp)this.parent).addChild(this);
        notifySubscribers(this);
    }
    public String toString(){
        return name;
    }

    @Override
    public void addSubscriber(Subscriber sub) {
        if(sub == null)
            return;
        if(this.subscribers ==null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(Subscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if(notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;
        for(int i=0;i<subscribers.size();i++){
            subscribers.get(i).update(notification);
        }
    }
}
