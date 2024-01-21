package app.gui.Swing.action;

import app.gui.Swing.view.PrezentacijaEditDialog;

import java.awt.event.ActionEvent;

public class PrezentacijaEditAction extends AbstractRudokAction{
    public PrezentacijaEditAction() {
        putValue(NAME, "EditPres");
        putValue(SHORT_DESCRIPTION, "Edit  presentation properties");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PrezentacijaEditDialog p=new PrezentacijaEditDialog();
        System.out.print("desio se edit");
    }
}
