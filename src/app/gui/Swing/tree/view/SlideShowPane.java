package app.gui.Swing.tree.view;

import app.Tree.Model.Prezentacija;
import app.Tree.Model.Slajd;
import app.gui.Swing.action.ExitSlideshowListener;
import app.gui.Swing.action.NextSlideActionListener;
import app.gui.Swing.action.PreviousSlideActionListener;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class SlideShowPane extends JPanel {
    List<SlajdView> prikaz;
    CardLayout cd1;
    JPanel jp;
    JButton prev;
    JButton next;
    JPanel donjiPanel;
    Prezentacija p;
    List<Slajd> slajds;

    public SlideShowPane(Prezentacija prez,List<SlajdView> slideshow) {
        System.out.println("NOvi objekat slideshowpanea");
        this.p=prez;
        slajds=new LinkedList<>();
        prikaz=new LinkedList<>();
        prikaz.addAll(slideshow);
        setLayout(new BorderLayout());
        JButton exit=new JButton("exitSlideshow");
        exit.addActionListener(new ExitSlideshowListener());
        add(exit,BorderLayout.NORTH);
        cd1= new CardLayout();
        jp=new JPanel(cd1);
        for (int i = 0; i < prikaz.size(); i++) {
            SlajdView component = new SlajdView((Slajd) (p.getChildAt(i)),false);
            //SlajdView component= sou.get(i);
            jp.add(component);
            //slidePanel.addMouseListener(new SlajdMouseListener(component));
        }
        add(jp, BorderLayout.CENTER);
        prev = new JButton("previous");
        next=new JButton("next");
        prev.addActionListener(new PreviousSlideActionListener(this));
        next.addActionListener(new NextSlideActionListener(this));
        donjiPanel=new JPanel();
        donjiPanel.add(prev);
        donjiPanel.add(next);
        add(donjiPanel,BorderLayout.SOUTH);
    }

    public void slideshowUpdate(List<SlajdView> sou) {
        /*jp.removeAll();
        for(int i=0;i<sou.size();i++){
            jp.add(sou.get(i));
        }*/// ovo radi i bez revalidate-a i repainta ali mora da se menja kod da bih namestio da ne bude editable(nisam na pocetku razumeo)
        jp.removeAll();
        prikaz.clear();
        for(int i=0;i<sou.size();i++){
            prikaz.add(sou.get(i));
        }
        for(int i=0;i<prikaz.size();i++){
            SlajdView component = new SlajdView((Slajd) (p.getChildAt(i)),false);
            jp.add(component);
            //slidePanel.addMouseListener(new SlajdMouseListener(component));
        }
        revalidate();
        repaint();
    }

    public CardLayout getCd1() {
        return cd1;
    }

    public JPanel getJp() {
        return jp;
    }
}
