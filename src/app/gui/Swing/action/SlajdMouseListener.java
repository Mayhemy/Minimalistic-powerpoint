package app.gui.Swing.action;

import app.PrezEditSlideState.AbstractEditSlideState;
import app.gui.Swing.tree.view.SlajdView;
import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class SlajdMouseListener implements MouseListener, MouseMotionListener {
    SlajdView slideView;
    static int brojac;
    int broj;
    public SlajdMouseListener(SlajdView slajdView) {
        this.slideView=slajdView;
        broj=brojac++;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        System.out.println(broj);
        ((AbstractEditSlideState)(((EditPane) MainFrame.getInstance().getActivePane()).getWorkspaceView().getTrenutni().selektovanTab().getStateEditSlideManager()).getCurrentState()).setSv(slideView);
        ((AbstractEditSlideState)(((EditPane) MainFrame.getInstance().getActivePane()).getWorkspaceView().getTrenutni().selektovanTab().getStateEditSlideManager()).getCurrentState()).mousePressed(e);
        /*if (e.getButton()==MouseEvent.BUTTON1){
            Point position = e.getPoint();


            //Paint fill = new GradientPaint(position.x, position.y, Color.RED,
            //	position.x+100, position.y+50, Color.BLUE);
            Paint fill = new Color(255,0,0);

            Slot slot=new Slot(position, new Dimension(100,50),
                    new BasicStroke(2f), fill);

            slot.setName("Rectangle");
            slideView.getS().addSlot(slot);
        }*/
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ((AbstractEditSlideState)(((EditPane) MainFrame.getInstance().getActivePane()).getWorkspaceView().getTrenutni().selektovanTab().getStateEditSlideManager()).getCurrentState()).setSv(slideView);
        ((AbstractEditSlideState)(((EditPane) MainFrame.getInstance().getActivePane()).getWorkspaceView().getTrenutni().selektovanTab().getStateEditSlideManager()).getCurrentState()).mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("desio se mousedragged1");
        ((AbstractEditSlideState)(((EditPane) MainFrame.getInstance().getActivePane()).getWorkspaceView().getTrenutni().selektovanTab().getStateEditSlideManager()).getCurrentState()).setSv(slideView);
        ((AbstractEditSlideState)(((EditPane) MainFrame.getInstance().getActivePane()).getWorkspaceView().getTrenutni().selektovanTab().getStateEditSlideManager()).getCurrentState()).mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
