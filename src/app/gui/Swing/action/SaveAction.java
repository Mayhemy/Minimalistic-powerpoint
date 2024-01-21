package app.gui.Swing.action;

import app.Tree.Model.Project;
import app.Tree.Model.RuNode;
import app.Tree.Model.Workspace;
import app.gui.Swing.tree.model.MyTreeNode;
import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class SaveAction extends AbstractRudokAction {
    public SaveAction() {
        /**
         * Pomoću metode apstraktne klase AbstractAction putValue
         * postavljamo vrednosti 4 od 8 konstanti
         * Kada povežemo ovaj Action sa bilo kojom komponentom koja nasleđuje JComponent
         * komponenta će iz ovih konstanti postaviti svoj Accelerator, Icon, Name i Description
         */

        /*putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK));*/
        putValue(NAME, "Save products");
        putValue(SHORT_DESCRIPTION, "Save products");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RuNode node = ((MyTreeNode) ((EditPane) (MainFrame.getInstance()).getActivePane()).getMyJTree().getLastSelectedPathComponent()).getNode();
        if (node instanceof Workspace) {
            for (int i = 0; i < ((Workspace) node).getChildren().size(); i++) {
                Project p=(Project)((Workspace) node).getChildren().get(i);
                projHelper(p);
            }
             WShelper((Workspace)node);
        } else if (node instanceof Project) {
            projHelper((Project) node);
        }
        SwingUtilities.updateComponentTreeUI(((EditPane) (MainFrame.getInstance()).getActivePane()).getMyJTree());
    }

        private void projHelper (Project node){
            Project project = node;
            File myObj = project.getProjectFile();
            if (!(project.isChanged())) {
                return;
            }
            if (project.getProjectFile() == null || project.isImportovan()) {
                try {
                    project.setChanged(false);
                    myObj = new File("ZProjectsSaveFolder/" + project.getName() + ".gpf");
                    if (myObj.createNewFile()) {
                        System.out.println("File created: " + myObj.getName());
                    } else {
                        System.out.println("File already exists.");
                    }
                } catch (IOException ex) {
                    System.out.println("An error occurred.");
                    ex.printStackTrace();
                }
            }
            ObjectOutputStream os;
            try {
                os = new ObjectOutputStream(new FileOutputStream(myObj));
                os.writeObject(project);
                project.setProjectFile(myObj);
                project.setChanged(false);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            project.setImportovan(false);
        }
    private void WShelper(Workspace ws){
        try {
            File myObj = new File("WorkspaceSaveFolder/"+ws.getName()+".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("WorkspaceSaveFolder/"+ws.getName()+".txt");
            for(int i=0;i<ws.getChildren().size();i++) {
                System.out.println(((Project)ws.getChildren().get(i)).getName());
                myWriter.write(((Project)ws.getChildren().get(i)).getProjectFile().getAbsolutePath());
                myWriter.write(System.getProperty( "line.separator" ));
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}