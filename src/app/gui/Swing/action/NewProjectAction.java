package app.gui.Swing.action;

import app.Error.ErrorFactory;
import app.NewNodeFactoryMethod.AbstractNodeFactory;
import app.NewNodeFactoryMethod.NodeFactoryGenerator;
import app.Tree.Model.Workspace.*;
import app.command.AddCommand;
import app.gui.Swing.tree.model.MyTreeNode;
import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewProjectAction extends AbstractRudokAction{
    public NewProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "New project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /*Object z= ((EditPane)(MainFrame.getInstance()).getActivePane()).getMyJTree().getLastSelectedPathComponent();
        if(z==null){
            ErrorFactory.getInstance().baciError("ErrorNothingSelected");
        }else {
            if (((MyTreeNode) z).getNode() instanceof Workspace) {
                ((MyTreeNode) z).addChild(new Project(((MyTreeNode) z).getNode()));
            } else if (((MyTreeNode) z).getNode() instanceof Project) {
                ((MyTreeNode) z).addChild(new Prezentacija(((MyTreeNode) z).getNode()));
            } else if (((MyTreeNode) z).getNode() instanceof Prezentacija) {
                ((MyTreeNode) z).addChild(new Slajd(((MyTreeNode) z).getNode()));
            }
        }*/

        SwingUtilities.updateComponentTreeUI(((EditPane)(MainFrame.getInstance()).getActivePane()).getMyJTree());
        MyTreeNode x = (MyTreeNode) ((EditPane) (MainFrame.getInstance()).getActivePane()).getMyJTree().getLastSelectedPathComponent();
        if(x==null){
            ErrorFactory.getInstance().baciError("ErrorNothingSelected");
        }else {
            ((EditPane)MainFrame.getInstance().getActivePane()).getCmdManager().addCommand(new AddCommand(x,false));
           /* AbstractNodeFactory f = NodeFactoryGenerator.returnNodeFactory(x);
            if(f==null){
                ErrorFactory.getInstance().baciError("ErrorSlideChild");
            }else {
                MyTreeNode dete = new MyTreeNode(f.getNFT(x.getNode()));
                x.addChild(dete);
            }*/

        }
        SwingUtilities.updateComponentTreeUI(((EditPane)(MainFrame.getInstance()).getActivePane()).getMyJTree());
        /*DiagramView view=new DiagramView();
        view.setDiagram(d);
        AppCore.getInstance().getDesktop().add(view);

        try {
            view.setSelected(true);
        } catch (PropertyVetoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/

    }
}
