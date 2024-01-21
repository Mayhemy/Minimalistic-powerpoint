package app.Handler;

import app.gui.Swing.tree.view.SlotView;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.geom.GeneralPath;
import java.util.HashMap;
import java.util.Map;

public class TextSlotHandler extends SlotHandler{
    public TextSlotHandler(SlotView sv) {
        super(sv);
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
        System.out.println("Desio se paint!!");
        Shape shape;
        int width=0;
        content=sv.getSlot().getContentWrap().getContent();
        boolean italic=false;
        boolean underline=false;
        Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
        fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        g.setFont(new Font("Serif", Font.PLAIN , 20));
        for(int i=0;i<content.length();i++){
            if(content.charAt(i)=='~' && italic==false){
                italic=true;
                continue;
            }else if(content.charAt(i)=='~' && italic==true){
                italic=false;
                continue;
            }else if(content.charAt(i)=='`' && underline==false){
                underline=true;
                continue;
            }else if(content.charAt(i)=='`' && underline==true){
                underline=false;
                continue;
            }
            if(italic && underline){
                Font italicUnderline = new Font("Serif",Font.ITALIC, 20).deriveFont(fontAttributes);
                g.setFont(italicUnderline);
            }else if(underline && !italic){
                Font plainUnderline = new Font("Serif",Font.PLAIN, 20).deriveFont(fontAttributes);
                g.setFont(plainUnderline);
            }else if(italic && !underline){
                g.setFont(new Font("Serif", Font.ITALIC , 20));
            }else{
                g.setFont(new Font("Serif", Font.PLAIN , 20));
            }
            width += g.getFontMetrics().stringWidth(String.valueOf(content.charAt(i)));
            g.drawString(String.valueOf(content.charAt(i)),sv.getSlot().getPosition().x+width,sv.getSlot().getPosition().y);
        }
        /*g.setPaint(Color.RED);
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(sv.getSlot().getPosition().x, sv.getSlot().getPosition().y);

        ((GeneralPath) shape).lineTo(sv.getSlot().getPosition().x + sv.getSlot().getSize().width, sv.getSlot().getPosition().y);

        ((GeneralPath) shape).lineTo(sv.getSlot().getPosition().x + sv.getSlot().getSize().width, sv.getSlot().getPosition().y + sv.getSlot().getSize().height);

        ((GeneralPath) shape).lineTo(sv.getSlot().getPosition().x, sv.getSlot().getPosition().y + sv.getSlot().getSize().height);

        ((GeneralPath) shape).closePath();
        g.draw(shape);*/
    }

    @Override
    public void format() {

    }

    @Override
    public void update(Object notification) {
        repaint();
    }
}
