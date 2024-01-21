package app.gui.Swing.action;

import app.gui.Swing.view.InfoDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoOkActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        InfoDialog.getInstance().ugasi();
    }
}
