package app.Tree.Model;

import java.awt.*;
import java.io.Serializable;

public class Slot implements Serializable {
    protected Dimension size;
    protected Point position;
    protected Paint paint;
    protected Paint originalPaint;
    protected SerializableStrokeAdapter stroke;
    //protected Stroke stroke;
    protected boolean selected;

    protected String name;
    protected String description;
    protected TipSlota type;
    protected SlotContent content;


    public Slot(Point position, Dimension size, Stroke stroke, Paint paint){
        selected=false;
        this.position=position;
        this.stroke=new SerializableStrokeAdapter(stroke);
        //this.stroke=stroke;
        this.paint=paint;
        this.size = size;
        this.originalPaint=paint;
        type=TipSlota.Text;
        content=new SlotContent();
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public Stroke getStroke() {
        return stroke.getStroke();
    }

    public void setStroke(Stroke stroke) {
        this.stroke = new SerializableStrokeAdapter(stroke);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        if(selected){
            this.paint=Color.CYAN;
        }else{
            this.paint=originalPaint;
        }
    }

    public TipSlota getType() {
        return type;
    }

    public void setType(TipSlota type) {
        this.type = type;
    }

    public void setContent(SlotContent content) {
        this.content = content;
    }

    public SlotContent getContentWrap() {
        return content;
    }
}
