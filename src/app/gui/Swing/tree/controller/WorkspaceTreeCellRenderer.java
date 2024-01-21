package app.gui.Swing.tree.controller;

import app.Tree.Model.Prezentacija;
import app.Tree.Model.Project;
import app.Tree.Model.Slajd;
import app.Tree.Model.Workspace;
import app.gui.Swing.tree.model.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class WorkspaceTreeCellRenderer extends DefaultTreeCellRenderer {

    public WorkspaceTreeCellRenderer() {

        // TODO Auto-generated constructor stub
    }

    public Component getTreeCellRendererComponent(
            JTree tree,
            Object value,
            boolean sel,
            boolean expanded,
            boolean leaf,
            int row,
            boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);


        if(((MyTreeNode)value).getNode() instanceof Workspace){
            //Icon icon = new ImageIcon("images/WorkspaceIcon.jpg");
            //setIcon(icon);
        }else if(((MyTreeNode)value).getNode() instanceof Project){
            Icon icon = new ImageIcon("images/projectIcon.jpg");
            setIcon(icon);
        }else if(((MyTreeNode)value).getNode() instanceof Prezentacija){
            Icon icon = new ImageIcon("images/presentationIcon.jpg");
            setIcon(icon);
        }else if(((MyTreeNode)value).getNode() instanceof Slajd){
            Icon icon = new ImageIcon("images/slideIcon.jpg");
            setIcon(icon);
        }

        return this;
    }

}

