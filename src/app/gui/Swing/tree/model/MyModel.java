package app.gui.Swing.tree.model;

import javax.swing.tree.DefaultTreeModel;


public class MyModel extends DefaultTreeModel {
    public MyModel() {
        super(new MyTreeNode());
    }

}