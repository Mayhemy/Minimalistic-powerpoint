package app.gui.Swing.tree.view;

import app.Tree.Model.Prezentacija;
import app.Tree.Model.Slajd;
import app.gui.Swing.action.PlaySlideshowListener;
import app.gui.Swing.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class EditPaneSmaller extends JPanel {
    JLabel ime;
    Prezentacija p;
    JPanel slidePanel;
    SlajdNavigator navigator;
    List<SlajdView> slideshow;
    JButton playSlideshow;
    JScrollPane workScrollPane;
    public EditPaneSmaller(Prezentacija prez ,List<SlajdView> sou) {
        this.p=prez;
        slideshow=new LinkedList<>();
        slideshow.addAll(sou);
        System.out.println("NAPRAVIO SE NOVI OBJEKAT");
        setLayout(new BorderLayout());
        ime = new JLabel(p.getAutor());
        playSlideshow = new JButton("Play");
        playSlideshow.addActionListener(new PlaySlideshowListener());
        JPanel north = new JPanel();
        north.setLayout(new FlowLayout());
        JPanel northPack=new JPanel();
        northPack.setLayout(new BoxLayout(northPack,BoxLayout.PAGE_AXIS));
        northPack.setAlignmentX(Component.LEFT_ALIGNMENT);
        JToolBar toolbar=new JToolBar();
        toolbar.setAlignmentX(Component.LEFT_ALIGNMENT);
        toolbar.add((MainFrame.getInstance()).getActionManager().getEditPaneAction());
        toolbar.add((MainFrame.getInstance()).getActionManager().getSlideshowPaneAction());
        toolbar.addSeparator();
        toolbar.add(MainFrame.getInstance().getActionManager().getEditStateAddAction());
        toolbar.add(MainFrame.getInstance().getActionManager().getEditStateDeleteAction());
        toolbar.add(MainFrame.getInstance().getActionManager().getEditStateMoveAction());
        toolbar.add(MainFrame.getInstance().getActionManager().getEditStateSelectAction());
        toolbar.add(MainFrame.getInstance().getActionManager().getSetColorAction());
        //toolbar.add(MainFrame.getInstance().getActionManager().getSlotHandlerAction());
        JPanel pomocni=new JPanel(new FlowLayout());
        pomocni.setAlignmentX(Component.LEFT_ALIGNMENT);
        pomocni.add(ime);
        pomocni.add(playSlideshow);
        northPack.add(pomocni);
        northPack.add(toolbar);
        add(northPack, BorderLayout.NORTH);
        slidePanel = new JPanel();
        slidePanel.setLayout(new BoxLayout(slidePanel,BoxLayout.PAGE_AXIS));
        for (int i = 0; i < sou.size(); i++) {
            SlajdView component = new SlajdView((Slajd) (p.getChildAt(i)));
            //SlajdView component= sou.get(i);
            slidePanel.add(component);
            slideshow.add(component);
            //slidePanel.addMouseListener(new SlajdMouseListener(component));
        }
        navigator = new SlajdNavigator(p);
        //navigator.setPreferredSize(new Dimension(200,300));
        add(navigator, BorderLayout.WEST);
        workScrollPane = new JScrollPane(slidePanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(workScrollPane, BorderLayout.CENTER);
    }

    public void editUpdate(List<SlajdView> sou) {
        slidePanel.removeAll();
        slideshow.clear();
        for(int i=0;i<sou.size();i++){
            slideshow.add(sou.get(i));
        }
        for(int i=0;i<slideshow.size();i++){
            SlajdView component = new SlajdView((Slajd) (p.getChildAt(i)));
            slidePanel.add(component);
            //slidePanel.addMouseListener(new SlajdMouseListener(component));
        }
        revalidate();
    }
    public List<SlajdView> getSlideshow() {
        return slideshow;
    }
}
