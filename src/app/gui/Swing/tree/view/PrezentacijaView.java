package app.gui.Swing.tree.view;

import app.PrezEditSlideState.StateEditSlideManager;
import app.Tree.Model.Prezentacija;
import app.Tree.Model.Slajd;
import app.Observer.Subscriber;
import app.PrezViewState.StateManager;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class PrezentacijaView extends JPanel implements Subscriber {
    Prezentacija p;
    List<SlajdView> slideshow;
    StateManager stateManager;
    StateEditSlideManager stateEditSlideManager;
    EditPaneSmaller praviView;
    SlideShowPane fakeView;
    List<Slajd> slajds;
    JPanel contentPane;

    public PrezentacijaView(Prezentacija p) {
        slajds=new LinkedList<>();
        slideshow=new LinkedList<>();
        this.p=p;
        this.p.addSubscriber(this);
        stateManager = new StateManager();
        stateEditSlideManager=new StateEditSlideManager();
        for(int i=0;i<p.getChildren().size();i++){
            slajds.add((Slajd)p.getChildAt(i));
            SlajdView slajdView=new SlajdView((Slajd)p.getChildAt(i));
            slideshow.add(slajdView);
        }
        praviView=new EditPaneSmaller(p,slideshow);
        fakeView=new SlideShowPane(p,slideshow);
        contentPane=new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(praviView,BorderLayout.CENTER);
        setLayout(new BorderLayout());
        add(contentPane,BorderLayout.CENTER);
    }


    @Override
    public void update(Object notification) {
        if(notification instanceof Prezentacija){
            if(slajds.size()<((Prezentacija)notification).getChildren().size()) {
                for(int i =0;i<(((Prezentacija) notification).getChildren().size());i++) {
                    if(!slajds.contains(((Prezentacija) notification).getChildAt(i))){
                        slajds.add((Slajd)((Prezentacija) notification).getChildAt(i));
                        SlajdView slajdView=new SlajdView((Slajd)((Prezentacija) notification).getChildAt(i));
                        slideshow.add(slajdView);
                    }
                }
            }else if(slajds.size()>((Prezentacija)notification).getChildren().size()){
                for(int i =0;i<slajds.size();i++){
                    if(!((Prezentacija) notification).getChildren().contains(slajds.get(i))){
                        slajds.remove(i);
                        slideshow.remove(i);
                    }
                }
            }
            praviView.editUpdate(slideshow);
            fakeView.slideshowUpdate(slideshow);
        }
        System.out.println("IIIIIIIIIIIII "+praviView.getSlideshow().size());
        revalidate();
    }

    public void startEditPaneState(){
        this.stateManager.setEditState();
    }

    public void startSlideshowPaneState(){
        this.stateManager.setSlideshowState();
    }
    public void play(){
        this.stateManager.getCurrentState().play(this);
    }
    public void setContentPaneEdit(){
        contentPane.removeAll();
        praviView=new EditPaneSmaller(p,slideshow);
        contentPane.add(praviView,BorderLayout.CENTER);
        add(contentPane,BorderLayout.CENTER);
        revalidate();
    }
    public void setContentPaneSlideshow() {
        contentPane.removeAll();
        fakeView = new SlideShowPane(p,slideshow);
        contentPane.add(fakeView,BorderLayout.CENTER);
        add(contentPane,BorderLayout.CENTER);
        revalidate();
    }

    public void setContentPane(JPanel contentPane) {
        this.contentPane = contentPane;
    }

    public StateManager getStateManager() {
        return stateManager;
    }

    public StateEditSlideManager getStateEditSlideManager() {
        return stateEditSlideManager;
    }
    public void startAddSlotState(){
        this.stateEditSlideManager.setAddSlotState();
    }

    public void startDeleteSlotState(){
        this.stateEditSlideManager.setDeleteSlotState();
    }

    public void startMoveSlotState(){
        this.stateEditSlideManager.setMoveSlotState();
    }

    public void startSelectSlotState(){
        this.stateEditSlideManager.setSelectSlotState();
    }

    public Prezentacija getP() {
        return p;
    }
}
