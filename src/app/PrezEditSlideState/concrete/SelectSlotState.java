package app.PrezEditSlideState.concrete;

import app.PrezEditSlideState.AbstractEditSlideState;
import app.Tree.Model.TipSlota;
import app.Handler.MultimediaSlotHandler;
import app.Handler.TextSlotHandler;
import app.gui.Swing.tree.view.SlotSlikaEditor;
import app.gui.Swing.tree.view.SlotTekstEditor;
import app.gui.Swing.tree.view.SlotView;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectSlotState extends AbstractEditSlideState {
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton()==MouseEvent.BUTTON1){
            Point position = e.getPoint();


            //Paint fill = new GradientPaint(position.x, position.y, Color.RED,
            //	position.x+100, position.y+50, Color.BLUE);

            for(SlotView s:slideView.getSlotViews()){
                if(s.elementAt(position)){
                    slideView.getS().setujSelektovanog(s.getSlot());
                    s.getSlot().setType(tipSLota);
                    System.out.println(s.getSlot().getType());
                    if(s.getSlot().getType()==TipSlota.Text){
                        s.setHandler(new TextSlotHandler(s));
                        new SlotTekstEditor(s);
                    }else if(s.getSlot().getType()==TipSlota.Slika){
                        s.setHandler(new MultimediaSlotHandler(s));
                        new SlotSlikaEditor(s);
                    }
                    break;
                }
            }
            // slideView.getS().addSlot();
        }
    }

}
