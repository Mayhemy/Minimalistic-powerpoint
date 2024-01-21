package app.gui.Swing.action;

import app.Tree.Model.Project;
import app.Tree.Model.RuNode;
import app.Tree.Model.RuNodeComp;
import app.Tree.Model.Workspace;
import app.gui.Swing.tree.model.MyTreeNode;
import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Scanner;

public class OpenProjectAction extends AbstractRudokAction {

    public OpenProjectAction() {

        /**
         * Pomoću metode apstraktne klase AbstractAction putValue
         * postavljamo vrednosti 4 od 8 konstanti
         * Kada povežemo ovaj Action sa bilo kojom komponentom koja nasleđuje JComponent
         * komponenta će iz ovih konstanti postaviti svoj Accelerator, Icon, Name i Description
         */

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(NAME, "Open project");
        putValue(SHORT_DESCRIPTION, "Open project");
    }

    public void actionPerformed(ActionEvent arg0) {
        JFileChooser jfc = new JFileChooser();

        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            if(jfc.getSelectedFile().getName().endsWith(".gpf")){
                File file =jfc.getSelectedFile();
                gpfHelper(file);
            }else if(jfc.getSelectedFile().getName().endsWith(".txt")){
                File file =jfc.getSelectedFile();
                txtHelper(file);
            }
        }
        SwingUtilities.updateComponentTreeUI(((EditPane)MainFrame.getInstance().getActivePane()).getMyJTree());
    }

    void addInorder(RuNode p, MyTreeNode parent) {
        if (!(p instanceof RuNodeComp)) {
            MyTreeNode dete = new MyTreeNode(p);
            parent.addChild(dete);
            return;
        }
        // Total children count

        int total = ((RuNodeComp) p).getChildren().size();
        MyTreeNode dete = new MyTreeNode(p);
        // All the children except the last
        for (int i = 0; i <= total - 1; i++)
            addInorder(((RuNodeComp) (p)).getChildren().get(i), dete);

        // Print the current node's data
         parent.addChild(dete);
        // Last child
        /*if(((RuNodeComp) (p)).getChildren().size()!=0)
            addInorder(((RuNodeComp) (p)).getChildren().get(total - 1), dete);*/
    }
    private void gpfHelper(File file){
        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream(file));

            Project p = null;
            try {
                p = (Project) os.readObject();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if(p!=null) {
                p.incBrojac();
                p.setChanged(true);
                p.setImportovan(true);
            }
            MyTreeNode x = (MyTreeNode) ((EditPane) (MainFrame.getInstance()).getActivePane()).getMyJTree().getLastSelectedPathComponent();
            if(!(x.getNode() instanceof Workspace)){
                return;
            }
            if (p != null) {
                addInorder(p,x);
            }
            ((EditPane) MainFrame.getInstance().getActivePane()).getWorkspaceView().getWorkspace().addChild(p);

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    private void txtHelper(File file){
        String token="";
        try (Scanner infile = new Scanner(file)) {
            while (infile.hasNextLine()) {
                token=infile.nextLine();
                File novi=new File(token);
                gpfHelper(novi);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
