package app.gui.Swing.action;

import app.Tree.Model.Workspace;
import app.command.RemoveCommand;
import app.gui.Swing.tree.model.MyTreeNode;
import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RemoveAction extends AbstractRudokAction {
    public RemoveAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
        putValue(NAME, "Remove");
        putValue(SHORT_DESCRIPTION, "Remove node");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /*Object z= ((EditPane)(MainFrame.getInstance()).getActivePane()).getMyJTree().getLastSelectedPathComponent();
        if(!(((MyTreeNode)z).getNode() instanceof Workspace)){
            ((MyTreeNode) z).removeChild();
        }*/
        SwingUtilities.updateComponentTreeUI(((EditPane)MainFrame.getInstance().getActivePane()).getMyJTree());

        MyTreeNode z = (MyTreeNode) ((EditPane) (MainFrame.getInstance()).getActivePane()).getMyJTree().getLastSelectedPathComponent();
        if(!(((MyTreeNode)z).getNode() instanceof Workspace)){
            ((EditPane)MainFrame.getInstance().getActivePane()).getCmdManager().addCommand(new RemoveCommand(z,false));
        }
        /*DiagramView view=new DiagramView();
        view.setDiagram(d);
        AppCore.getInstance().getDesktop().add(view);

        try {
            view.setSelected(true);
        } catch (PropertyVetoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        SwingUtilities.updateComponentTreeUI(((EditPane)MainFrame.getInstance().getActivePane()).getMyJTree());

    }

}
