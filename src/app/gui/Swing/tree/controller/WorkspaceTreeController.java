package app.gui.Swing.tree.controller;

import app.Tree.Model.Project;
import app.Tree.Model.Workspace;
import app.gui.Swing.tree.model.MyTreeNode;
import app.gui.Swing.tree.view.*;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class WorkspaceTreeController implements TreeSelectionListener {
    private ProjectView p;
    private Project s;
    private MyJTree myJTree;

    public WorkspaceTreeController(MyJTree myJTree) {
        this.myJTree = myJTree;
    }

    public void valueChanged(TreeSelectionEvent e) {
        // TODO Auto-generated method stub


        TreePath path=e.getPath();
        MyTreeNode node = (MyTreeNode) myJTree.getLastSelectedPathComponent();
        if(node.getNode() instanceof Workspace){
            WorkspaceView.getInstance().setModulo((Workspace)node.getNode());
        }else if(node.getNode() instanceof Project){
            for(int i=0; i<path.getPathCount(); i++){
                if(path.getPathComponent(i) instanceof MyTreeNode){

                    //selektovan je dijagram u stablu, potreno je pronaci odgovarajuci
                    //DiagramView i postaviti ga u fokus

                    System.out.println("getPath: "+e.getPath());
                    System.out.println("getPath: "+e.getNewLeadSelectionPath());
                    break;
                }
            }
            WorkspaceView.getInstance().setModel((Project)node.getNode());
       }/*else if(node.getNode() instanceof Prezentacija) {
           new PrezentacijaView((Prezentacija) node.getNode());
       }else if(node.getNode() instanceof Slajd) {
           new SlajdView((Slajd) node.getNode());
       }

        TreePath path= e.getPath();
        for(int i=0; i<path.getPathCount(); i++){
            if(path.getPathComponent(i) instanceof MyTreeNode){
                Slajd d=(Slajd)path.getPathComponent(i);

                //selektovan je dijagram u stablu, potreno je pronaci odgovarajuci
                //DiagramView i postaviti ga u fokus
                System.out.println("Selektovan dijagram:"+d);

                System.out.println("getPath: "+e.getPath());
                System.out.println("getPath: "+e.getNewLeadSelectionPath());
                break;
            }
        }
    }
            */
    }
}
