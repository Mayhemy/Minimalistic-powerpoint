package app.Handler;

import app.gui.Swing.tree.view.SlotView;

import javax.swing.*;
import java.awt.*;

public class MultimediaSlotHandler extends SlotHandler{
    private Image image;
    public MultimediaSlotHandler(SlotView sv) {
        super(sv);
        image=Toolkit.getDefaultToolkit().getImage(sv.getSlot().getContentWrap().getContent());
    }
    @Override
    public void readContent() {
        content=sv.getSlot().getContentWrap().getContent();
    }

    @Override
    public void setContent(String izmena) {
        sv.getSlot().getContentWrap().setContent(izmena);
    }

    @Override
    public void paint(Graphics2D g) {
        System.out.println("Desio se paint222!!");
        //Image image = new ImageIcon(sv.getSlot().getContentWrap().getContent()).getImage();
        image=Toolkit.getDefaultToolkit().getImage(sv.getSlot().getContentWrap().getContent());
        //Image image=new ImageIcon();
        g.drawImage(image,sv.getSlot().getPosition().x,sv.getSlot().getPosition().y,null);
    }
    private ImageIcon resize(String imgPath){
        ImageIcon path = new ImageIcon(imgPath);
        Image img = path.getImage();
        Image newImg = img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    @Override
    public void format() {

    }

    @Override
    public void update(Object notification) {
        repaint();
    }
}
