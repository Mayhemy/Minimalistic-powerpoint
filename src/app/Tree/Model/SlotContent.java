package app.Tree.Model;

import app.Observer.Publisher;
import app.Observer.Subscriber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SlotContent implements Publisher, Serializable {
    String content;
    transient List<Subscriber> subscribers;
    private static int brojac;

    public SlotContent() {
        this.content ="";
        brojac++;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifySubscribers(this);
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

    @Override
    public String toString() {
        return "SlotContent"+brojac;
    }
}
