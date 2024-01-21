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
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.Scanner;

public class MyWindowListener implements WindowListener {
    public MyWindowListener() {
    }

    @Override
    public void windowOpened(WindowEvent e) {
        JFileChooser jfc = new JFileChooser();

        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            if(jfc.getSelectedFile().getName().endsWith(".txt")){
                File novi=jfc.getSelectedFile();
                txtHelper(novi);
            }
        }else{

            File novi=new File("ZKontekstAplikacije/");
            File[] listOfFiles = novi.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                if(listOfFiles[i].getName().endsWith(".txt")){
                    txtHelper(listOfFiles[i]);
                }
                System.out.println(listOfFiles[i]);
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
            MyTreeNode x = (MyTreeNode) ((EditPane) (MainFrame.getInstance()).getActivePane()).getMyJTree().getModel().getRoot();
            if(!(x.getNode() instanceof Workspace)){
                return;
            }
            if (p != null) {
                addInorder(p,x);
            }
            System.out.println(((EditPane) MainFrame.getInstance().getActivePane()).getWorkspaceView().getWorkspace());
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

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Desio se window closed");
        RuNode node=((EditPane)MainFrame.getInstance().getActivePane()).getWorkspaceView().getWorkspace();
        for (int i = 0; i < ((Workspace) node).getChildren().size(); i++) {
            Project p=(Project)((Workspace) node).getChildren().get(i);
            projHelper(p);
        }
        WShelper((Workspace)node);
    }

    @Override
    public void windowClosed(WindowEvent e) {
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
                myObj = new File("ZKontekstAplikacije/" + project.getName() + ".gpf");
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
            File myObj = new File("ZKontekstAplikacije/"+ws.getName()+".txt");
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
            FileWriter myWriter = new FileWriter("ZKontekstAplikacije/"+ws.getName()+".txt");
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

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
