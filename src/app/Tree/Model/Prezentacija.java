package app.Tree.Model;

import java.io.Serializable;

public class Prezentacija extends RuNodeComp implements Serializable {
    private String slika;
    private String autor;
    private static int brojac;
    int broj;

    public Prezentacija() {
        slika="images/dust.jpg";
        autor="JA";
        brojac++;
        broj=brojac;
        notifySubscribers(this);
    }

    public Prezentacija(String name, RuNode parent) {
        super(name, parent);
        slika="images/dust.jpg";
        autor="JA";
        brojac++;
        broj=brojac;
        notifySubscribers(this);
    }
    public Prezentacija(RuNode parent){
        super(parent);
        slika="images/dust.jpg";
        autor="JA";
        brojac++;
        broj=brojac;
        notifySubscribers(this);
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
        notifySubscribers(this);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
        notifySubscribers(this);
    }
    public String getName(){
        return super.getName()+" "+ String.valueOf(broj);
    }
}
