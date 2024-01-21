package app.Tree.Model;

import java.awt.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Slajd extends RuNode implements Serializable {
    int redniBr;
    static int brojac;
    List<Slot> slotovi=new LinkedList<>();

    public Slajd() {
        redniBr=++brojac;
    }
    public Slajd(RuNode parent){
        super(parent);
        redniBr=++brojac;
        //this.redniBr= ((RuNodeComp)parent).getIndexOf(this);
        notifySubscribers(this);
    }

    public Slajd(String name, RuNode parent) {
        super(name, parent);
        redniBr=++brojac;
        notifySubscribers(this);
    }

    public int getRedniBr() {
        return redniBr;
    }

    public void setRedniBr(int redniBr) {
        this.redniBr = redniBr;
        notifySubscribers(this);
    }

    public List<Slot> getSlotovi() {
        return slotovi;
    }

    public void setSlotovi(List<Slot> slotovi) {
        this.slotovi = slotovi;
        notifySubscribers(this);
    }
    public void addSlot(Slot slot){
        this.slotovi.add(slot);
        notifySubscribers(this);
    }
    public void removeSlot(Slot slot){
        this.slotovi.remove(slot);
        notifySubscribers(this);
    }
    public void setujSelektovanog(Slot slot){
        for(Slot s:slotovi){
            if(s.equals(slot)){
                s.setSelected(true);
            }else{
                s.setSelected(false);
            }
        }
        notifySubscribers(this);
    }
    public void pomeriSelektovanog(Point coords){
        for(Slot s:slotovi){
            if(s.isSelected()){
                s.setPosition(coords);
            }
        }
        notifySubscribers(this);
    }
    public void ukolniSelektovanog(){
        for(Slot s: slotovi){
            if(s.isSelected()){
                s.setSelected(false);
            }
        }
        notifySubscribers(this);
    }
    /*@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Slajd prosledjeni = (Slajd) obj;
        return name.equals(prosledjeni.name) &&  parent.equals(prosledjeni.parent) && slotovi.equals(prosledjeni.slotovi);
    }*/
}
