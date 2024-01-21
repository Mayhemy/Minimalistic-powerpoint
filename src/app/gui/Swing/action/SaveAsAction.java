package app.gui.Swing.action;

import app.Tree.Model.Project;
import app.Tree.Model.RuNode;
import app.Tree.Model.Workspace;
import app.gui.Swing.tree.model.MyTreeNode;
import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import java.awt.event.ActionEvent;
import java.io.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class SaveAsAction extends AbstractRudokAction{


    public SaveAsAction() {
        /**
         * Pomoću metode apstraktne klase AbstractAction putValue
         * postavljamo vrednosti 4 od 8 konstanti
         * Kada povežemo ovaj Action sa bilo kojom komponentom koja nasleđuje JComponent
         * komponenta će iz ovih konstanti postaviti svoj Accelerator, Icon, Name i Description
         */

        /*putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK));*/
        putValue(NAME, "Save As products");
        putValue(SHORT_DESCRIPTION, "Save As products");
    }

    public void actionPerformed(ActionEvent arg0) {
        RuNode node=((MyTreeNode) ((EditPane) (MainFrame.getInstance()).getActivePane()).getMyJTree().getLastSelectedPathComponent()).getNode();
        if(node instanceof Workspace) {
            for(int i=0;i<((Workspace) node).getChildren().size();i++){
                if(((Project)((Workspace) node).getChildren().get(i)).getProjectFile()==null)
                    helper((Project)((Workspace) node).getChildren().get(i));
            }
            WShelper((Workspace)node);
        }else if(node instanceof Project){
            helper((Project)node);
        }
            /*Project project;
            project = (Project)((MyTreeNode) ((EditPane) (MainFrame.getInstance()).getActivePane()).getMyJTree().getLastSelectedPathComponent()).getNode();
            File projectFile=project.getProjectFile();
            if (!project.isChanged()){
                return;
            }
            if (project.getProjectFile()==null){
                if(jfc.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
                    projectFile=jfc.getSelectedFile();

                }else{
                    return;
                }

            }


            ObjectOutputStream os;
            try {
                os = new ObjectOutputStream(new FileOutputStream(projectFile));
                os.writeObject(project);
                project.setProjectFile(projectFile);
                project.setChanged(false);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }*/
        SwingUtilities.updateComponentTreeUI(((EditPane)(MainFrame.getInstance()).getActivePane()).getMyJTree());
    }

   private void helper(Project p){
       JFileChooser jfc = new JFileChooser();
       jfc.setFileFilter(new DiagramFileFilter());
       Project project=p;
       //project = (Project)((MyTreeNode) ((EditPane) (MainFrame.getInstance()).getActivePane()).getMyJTree().getLastSelectedPathComponent()).getNode();
       File projectFile=project.getProjectFile();
       if (!project.isChanged()){
           return;
       }
       if (project.getProjectFile()==null || project.isImportovan()){
           if(jfc.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
               projectFile=new File(jfc.getSelectedFile()+".gpf");
           }else{
               return;
           }
            project.setImportovan(false);
       }


       ObjectOutputStream os;
       try {
           os = new ObjectOutputStream(new FileOutputStream(projectFile));
           os.writeObject(project);
           project.setProjectFile(projectFile);
           project.setChanged(false);
       } catch (FileNotFoundException e1) {
           e1.printStackTrace();
       } catch (IOException e1) {
           e1.printStackTrace();
       }
   }
   private void WShelper(Workspace ws){
       JFileChooser jfc = new JFileChooser();
       Workspace workspace=ws;
       File workspaceFile;
       //project = (Project)((MyTreeNode) ((EditPane) (MainFrame.getInstance()).getActivePane()).getMyJTree().getLastSelectedPathComponent()).getNode();
       if(jfc.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
           workspaceFile=new File(jfc.getSelectedFile()+".txt");
       }else{
           return;
       }

       try {
           FileWriter myWriter = new FileWriter(workspaceFile);
           for(int i=0;i<workspace.getChildren().size();i++) {
               myWriter.write(((Project)workspace.getChildren().get(i)).getProjectFile().getAbsolutePath());
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