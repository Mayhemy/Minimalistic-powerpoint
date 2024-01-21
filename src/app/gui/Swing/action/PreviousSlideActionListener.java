package app.gui.Swing.action;

import app.gui.Swing.tree.view.SlideShowPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreviousSlideActionListener implements ActionListener {
    SlideShowPane slideShowPane;
    public PreviousSlideActionListener(SlideShowPane sp) {
        this.slideShowPane=sp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        slideShowPane.getCd1().previous(slideShowPane.getJp());
    }
}
