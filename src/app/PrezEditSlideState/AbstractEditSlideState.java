package app.PrezEditSlideState;

import app.Tree.Model.TipSlota;
import app.gui.Swing.tree.view.SlajdView;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class AbstractEditSlideState {
    protected SlajdView slideView;
    protected Stroke stroke=new BasicStroke(7f);
    protected Paint fill=new Color(255,255,255);
    protected float borderWidth=7f;
    protected float dashLength=0f;
    protected TipSlota tipSLota;
    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
    }

    public void setSv(SlajdView sv) {
        this.slideView = sv;
    }

    public Stroke getStroke() {
        return null;
    }

    public void setStroke(Stroke stroke) {

    }

    public Paint getFill() {
        return null;
    }

    public void setFill(Paint fill) {

    }

    public float getBorderWidth() {
        return 0;
    }

    public void setBorderWidth(float border) {
    }

    public float getDashLength() {
        return 0;
    }

    public void setDashLength(float dashLength) {
    }

    public TipSlota getTipSLota() {
        return tipSLota;
    }

    public void setTipSLota(TipSlota tipSLota) {
        this.tipSLota = tipSLota;
    }
}
