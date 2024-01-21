package app.PrezEditSlideState.concrete;

import app.PrezEditSlideState.AbstractEditSlideState;
import app.Tree.Model.Slot;

import java.awt.*;
import java.awt.event.MouseEvent;

public class AddSlotState extends AbstractEditSlideState {

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton()==MouseEvent.BUTTON1){
            Point position = e.getPoint();


            //Paint fill = new GradientPaint(position.x, position.y, Color.RED,
            //	position.x+100, position.y+50, Color.BLUE);
            float niz[]=new float[1];
            niz[0]=dashLength;
            if(niz[0]!=0){
                stroke=new BasicStroke(borderWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
                        0, niz, 0);
            }else{
                stroke=new BasicStroke(borderWidth);
            }
            Slot slot=new Slot(position, new Dimension(100,50), stroke, fill);

            slot.setName("Rectangle");
            slideView.getS().addSlot(slot);
        }
    }

    public void setStroke(Stroke s) {
        this.stroke = s;
    }

    public void setFill(Paint fill) {
        this.fill = fill;
    }

    public float getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(float borderWidth) {
        this.borderWidth=borderWidth;
    }
    public void setDashLength(float dashLength) {
        this.dashLength = dashLength;
    }
}
