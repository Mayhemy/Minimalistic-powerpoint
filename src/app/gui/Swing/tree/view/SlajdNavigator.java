package app.gui.Swing.tree.view;

import app.Tree.Model.Prezentacija;
import app.Tree.Model.Slajd;
import app.Observer.Subscriber;

import javax.swing.*;
import java.awt.*;

public class SlajdNavigator extends JPanel implements Subscriber {
    Prezentacija p;
    JPanel slidePanel;
    public SlajdNavigator(Prezentacija p) {
        this.p=p;
        this.p.addSubscriber(this);
        setLayout(new BorderLayout());
        slidePanel=new JPanel();
        slidePanel.setLayout(new BoxLayout(slidePanel,BoxLayout.PAGE_AXIS));
        for(int i=0;i<p.getChildren().size();i++){
            JPanel component=new SlajdView((Slajd)(p.getChildAt(i)),false);
            component.setPreferredSize(new Dimension(200,100));
            //component.setMaximumSize(new Dimension(100,100));
            slidePanel.add(component);
        }
        add(slidePanel,BorderLayout.CENTER);
    }

    @Override
    public void update(Object notification) {
        slidePanel.removeAll();
        for(int i=0;i<((Prezentacija)notification).getChildren().size();i++){
            JPanel component=new SlajdView((Slajd)(p.getChildAt(i)),false);
            //component.setMaximumSize(new Dimension(100,100));
            component.setPreferredSize(new Dimension(200,100));
            slidePanel.add(component);
        }
    }
}
