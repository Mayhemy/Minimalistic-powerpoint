package app.gui.Swing.tree.view;

import app.Tree.Model.Slot;
import app.Tree.Model.TipSlota;
import app.Handler.MultimediaSlotHandler;
import app.Handler.SlotHandler;
import app.Handler.TextSlotHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class SlotView extends JPanel{
    Slot s;
    Shape shape;
    SlotHandler handler;
    boolean editable;
    JPanel jp1;
    private static int brojac;

    public SlotView(Slot s, boolean ...edit) {
        brojac++;
        jp1=new JPanel();
        this.s = s;
        editable = edit.length > 0 ? edit[0] : true;
        this.add(jp1);
        if(s.getType()==TipSlota.Text){
            handler=new TextSlotHandler(this);
        }else if(s.getType()==TipSlota.Slika){
            handler=new MultimediaSlotHandler(this);
        }
        s.getContentWrap().addSubscriber(handler);
    }
    public void paint (Graphics2D g){

        if(!editable && handler!=null){
            handler.paint(g);
        }else if(editable) {
            g.setPaint(Color.RED);
            shape = new GeneralPath();
            ((GeneralPath) shape).moveTo(s.getPosition().x, s.getPosition().y);

            ((GeneralPath) shape).lineTo(s.getPosition().x + s.getSize().width, s.getPosition().y);

            ((GeneralPath) shape).lineTo(s.getPosition().x + s.getSize().width, s.getPosition().y + s.getSize().height);

            ((GeneralPath) shape).lineTo(s.getPosition().x, s.getPosition().y + s.getSize().height);

            ((GeneralPath) shape).closePath();

            g.setStroke(s.getStroke());
            g.draw(shape);
            g.setPaint(s.getPaint());

            g.fill(shape);
        }

    }

    public boolean elementAt(Point pos){
        return shape.contains(pos);
    }

    public Slot getSlot() {
        return s;
    }

    public void setHandler(SlotHandler handler) {
        jp1.removeAll();
        this.handler = handler;
        jp1.add(handler);
    }

    public SlotHandler getHandler() {
        return handler;
    }

    public boolean isEditable() {
        return editable;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return "SlotView"+brojac;
    }
}
