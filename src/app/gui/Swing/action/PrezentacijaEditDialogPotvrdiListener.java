package app.gui.Swing.action;

import app.Error.ErrorFactory;
import app.Tree.Model.Prezentacija;
import app.gui.Swing.tree.model.MyTreeNode;
import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;
import app.gui.Swing.view.PrezentacijaEditDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrezentacijaEditDialogPotvrdiListener implements ActionListener {
    PrezentacijaEditDialog p;
    public PrezentacijaEditDialogPotvrdiListener(PrezentacijaEditDialog p1) {
        this.p=p1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object z= ((EditPane)MainFrame.getInstance().getActivePane()).getMyJTree().getLastSelectedPathComponent();
        String test=p.getSlika();
        if(!(test.equals("images/cvece.png") || test.equals("images/d1.jpg") || test.equals("images/d2.jpg") || test.equals("images/d3.jpg") || test.equals("images/de_dust2.png") || test.equals("images/dust.jpg"))){
            ErrorFactory.getInstance().baciError("ErrorInvalidPath");
        }else {
            if (((MyTreeNode) z).getNode() instanceof Prezentacija) {
                ((Prezentacija) ((MyTreeNode) z).getNode()).setAutor(p.getAutor());
                ((Prezentacija) ((MyTreeNode) z).getNode()).setSlika(p.getSlika());
            }
        }
        p.setVisible(false);
        SwingUtilities.updateComponentTreeUI(((EditPane)MainFrame.getInstance().getActivePane()).getMyJTree());
    }
}
