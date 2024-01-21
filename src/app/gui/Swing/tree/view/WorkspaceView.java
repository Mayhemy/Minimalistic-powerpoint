package app.gui.Swing.tree.view;

import app.Tree.Model.Prezentacija;
import app.Tree.Model.Project;
import app.Tree.Model.Workspace;
import app.Observer.Subscriber;
import app.gui.Swing.tree.model.MyTreeNode;
import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class WorkspaceView extends JPanel implements Subscriber {
    private static WorkspaceView instance;
    private List<ProjectView> projectViews;
    private ProjectView trenutni;
    private List<Project> projects;
    private Workspace workspace;
    private JPanel glavni;
    private Prezentacija copied;
    private  WorkspaceView(){
    }
    private void initialise(){
        projectViews=new LinkedList<>();
        projects=new LinkedList<>();
        glavni=new JPanel();
        glavni.setLayout(new BorderLayout());
        setLayout(new BorderLayout());
        add(glavni,BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    public static WorkspaceView getInstance() {
        if (instance == null) {
            instance = new WorkspaceView();
            instance.initialise();
        }
        return instance;
    }
    public void setModel(Project p){
        glavni.removeAll();
        System.out.println("desio se setMOdel ");
        System.out.println(projectViews.isEmpty());
        System.out.println(projects.indexOf(p));
        /*for(int i=0;i<projectViews.size();i++){
            if(projectViews.get(i).getP().equals(p)){
                trenutni=projectViews.get(i);
            }
        }*/
        trenutni=projectViews.get(projects.indexOf(p));
        glavni.add(trenutni);
        revalidate();
        repaint();
    }
    public void setModulo(Workspace ws){
        this.workspace=ws;
        this.workspace.addSubscriber(this);
    }
    @Override
    public void update(Object notification) {
        glavni.removeAll();
        if(notification instanceof Workspace) {
            System.out.println("evo nas");
            if (projects.size() < ((Workspace) notification).getChildren().size()){
                for (int i = 0; i < ((Workspace) notification).getChildren().size(); i++) {
                    if (!projects.contains(((Workspace) notification).getChildAt(i))) {
                        projects.add((Project) ((Workspace) notification).getChildAt(i));
                        projectViews.add(new ProjectView((Project) ((Workspace) notification).getChildAt(i)));
                    }
                }
            }else if(projects.size()>((Workspace)notification).getChildren().size()){
                for(int i = 0; i < projects.size(); i++) {
                    if (!((Workspace) notification).getChildren().contains(projects.get(i))) {
                        projectViews.remove(i);
                        projects.remove(i);
                    }
                }
            }
        }
        /*if(notification instanceof Workspace) {
            for(int i=0;i<((Workspace) notification).getChildren().size();i++){
                if(!projectViews.get(i).getP().equals(((Workspace) notification).getChildAt(i))){
                    projectViews.add(new ProjectView((Project)w ))
                }
            }
            if(pronasao==false){
                projectViews.add(new ProjectView((Project) ((Workspace) notification).getChildAt(((Workspace) notification).getChildren().size()-1)));
            }
        }*/
        if(!projectViews.contains(trenutni) && !projectViews.isEmpty()){
            trenutni=projectViews.get(0);
            glavni.removeAll();
            glavni.add(trenutni);
        }else if(!projectViews.contains(trenutni) && projectViews.isEmpty()){
            trenutni=null;
            glavni.removeAll();
        }
        revalidate();
    }

    public ProjectView getTrenutni() {
        return trenutni;
    }

    public Workspace getWorkspace() {
        return workspace;
    }

    public void setWorkspace(Workspace ws) {
        this.workspace=ws;
        this.workspace.addSubscriber(this);
    }

    public Prezentacija getCopied() {
        return copied;
    }

    public void setCopied(Prezentacija copied) {
        this.copied = copied;
    }
}