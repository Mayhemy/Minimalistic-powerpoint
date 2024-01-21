package app.gui.Swing.tree.view;

import app.Observer.Subscriber;
import app.Tree.Model.SlotContent;
import app.gui.Swing.action.SlikaEditorPotvrdiListener;
import app.gui.Swing.action.SlotMultimediaEditorListener;
import app.gui.Swing.view.MainFrame;

import javax.swing.*;
import java.awt.*;

public class SlotSlikaEditor extends JDialog implements Subscriber {
    private SlotView slotView;
    private JTextPane slika;
    private Icon ikonica;
    private JPanel jp1;
    private JButton edit;
    private JButton potvrdi;
    public SlotSlikaEditor(SlotView slotView) {
        super(MainFrame.getInstance(), true);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setLocationRelativeTo(MainFrame.getInstance());
        setSize(500,300);
        setLayout(new BorderLayout());
        this.slika=new JTextPane();
        this.slotView=slotView;
        this.slotView.getSlot().getContentWrap().addSubscriber(this);
        edit=new JButton("Edit");
        potvrdi=new JButton("Potvrdi");
        edit.addActionListener(new SlotMultimediaEditorListener(this.slotView.getSlot()));
        potvrdi.addActionListener(new SlikaEditorPotvrdiListener(this));
        jp1=new JPanel();
        slika.setPreferredSize(new Dimension(300,300));
        slika.insertIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(slotView.getSlot().getContentWrap().getContent())));
        jp1.add(edit);
        jp1.add(slika);
        //jp1.add(potvrdi);
        this.add(jp1,BorderLayout.CENTER);
        this.add(potvrdi, BorderLayout.SOUTH);
        setVisible(true);
    }


    @Override
    public void update(Object notification) {
        System.out.println("SLIKA ZA UPDATE "+slotView+slotView.getSlot().getContentWrap());
        jp1.remove(slika);
        slika=new JTextPane();
        slika.setPreferredSize(new Dimension(300,300));
        Icon icon;
        if(notification instanceof SlotContent) {
          icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(((SlotContent) notification).getContent()));
          System.out.println("SLIKA ZA UPDATE "+slotView+slotView.getSlot().getContentWrap());
          slika.insertIcon(icon);
        }
        jp1.add(slika);
        jp1.revalidate();
    }
}
