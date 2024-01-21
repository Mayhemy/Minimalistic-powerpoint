package app.PrezEditSlideState.concrete;

import app.PrezEditSlideState.AbstractEditSlideState;
import app.gui.Swing.tree.view.SlotView;

import java.awt.*;
import java.awt.event.MouseEvent;

public class DeleteSlotState extends AbstractEditSlideState {
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton()==MouseEvent.BUTTON1){
            Point position = e.getPoint();


            //Paint fill = new GradientPaint(position.x, position.y, Color.RED,
            //	position.x+100, position.y+50, Color.BLUE);
            for(SlotView s:slideView.getSlotViews()){
                if(s.elementAt(position)){
                    //slideView.getSlotViews().remove(s);
                    slideView.getS().removeSlot(s.getSlot());
                    break;
                }
            }
           // slideView.getS().addSlot();
        }
    }
}
