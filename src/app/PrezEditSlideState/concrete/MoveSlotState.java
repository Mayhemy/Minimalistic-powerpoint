package app.PrezEditSlideState.concrete;

import app.PrezEditSlideState.AbstractEditSlideState;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MoveSlotState extends AbstractEditSlideState {
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Desio se mouse pressed u move slot state");
        if (e.getButton() == MouseEvent.BUTTON1) {
            Point position = e.getPoint();


            //Paint fill = new GradientPaint(position.x, position.y, Color.RED,
            //	position.x+100, position.y+50, Color.BLUE);

            /*for (SlotView s : slideView.getSlotViews()) {
                if (s.elementAt(position)) {
                    slideView.getS().setujSelektovanog(s.getSlot());
                    pomeranjeModel = s.getSlot();
                    break;
                }

                // slideView.getS().addSlot();
            }*/
        }
    }
    @Override
    public void mouseDragged(MouseEvent e){
        System.out.println("Desio se mouse dragged2");
        Point coords = new Point(e.getX(), e.getY());
        slideView.getS().pomeriSelektovanog(coords);
        // slideView.getS().addSlot();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        slideView.getS().ukolniSelektovanog();
    }
}
