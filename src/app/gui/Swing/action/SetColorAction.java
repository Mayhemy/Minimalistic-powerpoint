package app.gui.Swing.action;

import app.gui.Swing.tree.view.ColorPickerDialog;
import app.gui.Swing.view.PrezentacijaEditDialog;

import java.awt.event.ActionEvent;

public class SetColorAction extends AbstractRudokAction{
    public SetColorAction() {
        putValue(NAME, "Slot properties");
        putValue(SHORT_DESCRIPTION, "Change slot color");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ColorPickerDialog cpd=new ColorPickerDialog();
        System.out.print("desio se edit");
    }
}
