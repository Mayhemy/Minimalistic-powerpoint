package app.gui.Swing.action;

import app.gui.Swing.view.InfoDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class InfoAction extends AbstractRudokAction{

    //InfoDialog infoDialog=new InfoDialog();--ipak sam odlucio da ovo bude singleton jer je logicnije
    public InfoAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(NAME, "Info");
        putValue(SHORT_DESCRIPTION, "Information about the creator of this magnificent artwork (moi)");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        InfoDialog.getInstance().setVisible(true);
    }
}
