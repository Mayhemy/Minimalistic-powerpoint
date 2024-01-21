package app.gui.Swing.tree.controller;

import app.command.ChangeNameCommand;
import app.command.RemoveCommand;
import app.gui.Swing.tree.model.MyTreeNode;
import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class WorkspaceTreeEditor extends DefaultTreeCellEditor implements ActionListener {


        private Object stavka=null;
        private JTextField edit=null;

        public WorkspaceTreeEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
        super(arg0, arg1);
    }


        public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {

            //super.getTreeCellEditorComponent(arg0,arg1,arg2,arg3,arg4,arg5);
            stavka=arg1;

            edit=new JTextField(arg1.toString());
            edit.addActionListener(this);
            return edit;
        }

        public boolean isCellEditable(EventObject arg0) {
            if (arg0 instanceof MouseEvent)
                if (((MouseEvent)arg0).getClickCount()==3){
                    return true;
                }
            return false;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(stavka instanceof MyTreeNode){
                ((EditPane)MainFrame.getInstance().getActivePane()).getCmdManager().addCommand(new ChangeNameCommand((MyTreeNode)stavka,false,e.getActionCommand()));
                //((MyTreeNode) stavka).getNode().setName(e.getActionCommand());
            }
            SwingUtilities.updateComponentTreeUI(((EditPane)MainFrame.getInstance().getActivePane()).getMyJTree());
            /*if (stavka instanceof Project) {
                ((Project) stavka).setName(e.getActionCommand());
                (((MyTreeNode)stavka).getNode()).setName(e.getActionCommand());
            } else if(((MyTreeNode)stavka).getNode() instanceof Prezentacija) {
                (((MyTreeNode)stavka).getNode()).setName(e.getActionCommand());
            }else if (((MyTreeNode)stavka).getNode() instanceof Slajd){
                (((MyTreeNode)stavka).getNode()).setName(e.getActionCommand());
            }else{
                 provera samo da li radi ista (((MyTreeNode)stavka).getNode()).setName(e.getActionCommand());
            }
            return;*/
        }
    }