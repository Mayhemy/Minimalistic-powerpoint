package app.gui.Swing.tree.controller;

import app.Tree.Model.Project;
import app.Tree.Model.Workspace;
import app.gui.Swing.tree.model.MyTreeNode;
import app.gui.Swing.tree.view.WorkspaceView;
import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TreeMouseListener implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount()==2)
        {
            System.out.println("Click\n");
            MyTreeNode node=(MyTreeNode) (((EditPane)(MainFrame.getInstance()).getActivePane()).getMyJTree().getLastSelectedPathComponent());
            if(node.getNode() instanceof Workspace){
                WorkspaceView.getInstance().setModulo((Workspace)node.getNode());
            }else if(node.getNode() instanceof Project){
                System.out.println("Clack\n");
                WorkspaceView.getInstance().setModel((Project) node.getNode());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
