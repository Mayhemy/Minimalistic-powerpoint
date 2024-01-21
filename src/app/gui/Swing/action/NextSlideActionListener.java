package app.gui.Swing.action;

import app.gui.Swing.tree.view.SlideShowPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextSlideActionListener implements ActionListener {
    SlideShowPane slideShowPane;
    public NextSlideActionListener(SlideShowPane sp) {
        this.slideShowPane=sp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        slideShowPane.getCd1().next(slideShowPane.getJp());
    }
}
