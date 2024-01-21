package app.gui.Swing.tree.view;

import app.gui.Swing.tree.controller.TreeMouseListener;
import app.gui.Swing.tree.controller.WorkspaceTreeCellRenderer;
import app.gui.Swing.tree.controller.WorkspaceTreeController;
import app.gui.Swing.tree.controller.WorkspaceTreeEditor;
import app.gui.Swing.tree.model.MyModel;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;

public class MyJTree extends JTree {

    public MyJTree(MyModel myModel) {
        setModel(myModel);
        addTreeSelectionListener(new WorkspaceTreeController(this));
        setCellEditor(new WorkspaceTreeEditor(this,new DefaultTreeCellRenderer()));
        setCellRenderer(new WorkspaceTreeCellRenderer());
        setEditable(true);
        addMouseListener(new TreeMouseListener());
    }

}
