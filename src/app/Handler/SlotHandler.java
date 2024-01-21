package app.Handler;

import app.Observer.Subscriber;
import app.gui.Swing.tree.view.SlotView;

import javax.swing.*;
import java.awt.*;

public abstract class SlotHandler extends JTextPane implements Subscriber {
    SlotView sv;
    String content;

    public SlotHandler(SlotView sv) {
        this.sv = sv;
    }

    public abstract void readContent();
    public abstract void setContent(String s);
    public abstract void paint(Graphics2D g);
    public abstract void format();
}
