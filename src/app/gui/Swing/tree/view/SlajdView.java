package app.gui.Swing.tree.view;

import app.Tree.Model.Prezentacija;
import app.Tree.Model.Slajd;
import app.Tree.Model.Slot;
import app.Observer.Subscriber;
import app.gui.Swing.action.SlajdMouseListener;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class SlajdView extends JPanel implements Subscriber {
    Slajd s;
    JLabel ime;
    Image image;
    List<Slot> slots;
    List<SlotView> slotViews;
    boolean editable;
    public SlajdView(Slajd s, boolean... edit) {
        editable = edit.length > 0 ? edit[0] : true;
        ime=new JLabel();
        slots=new LinkedList<>();
        slotViews=new LinkedList<>();
        this.s=s;
        this.s.addSubscriber(this);
        this.setLayout(new BorderLayout());
        //redniBr.setText();
        ime.setText(s.getName()+" "+s.getRedniBr());
        JPanel jp1=new JPanel();
        jp1.add(ime);
        add(jp1,BorderLayout.NORTH);
        image=Toolkit.getDefaultToolkit().getImage(((Prezentacija)(s.getParentNode())).getSlika());
        //glavniViewTest=new JPanel();
        //glavniViewTest.setSize(300,300);
        //glavniViewTest.setLayout(new BorderLayout());
        if(editable==true) {
            setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
            SlajdMouseListener listener=new SlajdMouseListener(this);
            addMouseListener(listener);
            addMouseMotionListener(listener);
        }
        for(Slot slot:s.getSlotovi()){
            SlotView sv;
            if(!editable) {
                sv = new SlotView(slot,false);
            }else{
                sv = new SlotView(slot);
            }
            slotViews.add(sv);
        }
        //this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        //this.addMouseListener(new SlajdMouseListener(this));
        //add(glavniViewTest,BorderLayout.CENTER);
        setSize(310,310);
        setPreferredSize(new Dimension(300,300));
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
        g.drawImage(image, 0, 0,this.getWidth(),this.getHeight(),null);

        //omogucava providnost elemenata prilikom njihovog preklapanja
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
        if(s==null){
            System.out.println("AHAAAAA");
        }
        for(SlotView sv: slotViews) {
            sv.paint(g2);
        }
        System.out.println("Izvršena paintComponent metoda view-a");
    }
    @Override
    public void update(Object notification) {
        ime.setText(((Slajd)notification).getName()+" "+((Slajd)notification).getRedniBr());
        image=Toolkit.getDefaultToolkit().getImage(((Prezentacija)(s.getParentNode())).getSlika());
        slotViews.clear();

        for(Slot slot:s.getSlotovi()){
            SlotView sv = new SlotView(slot);
            slotViews.add(sv);
        }
        revalidate();
        repaint();
    }
    public Slajd getS() {
        return s;
    }

    public List<SlotView> getSlotViews() {
        return slotViews;
    }
}
