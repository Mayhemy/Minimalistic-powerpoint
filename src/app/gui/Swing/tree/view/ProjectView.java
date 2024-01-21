package app.gui.Swing.tree.view;

import app.Tree.Model.Prezentacija;
import app.Tree.Model.Project;
import app.Observer.Subscriber;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class ProjectView extends JPanel implements Subscriber {
    private JTabbedPane tabs;
    private JLabel ime;
    private JLabel l;
    private List<Prezentacija> prezList;
    private List<PrezentacijaView> prezentacijaViewList;
    //PrezentacijaView prezentacijaView;
    //SlajdView slajdView;
    private Project p;
    public  ProjectView(Project p){
        prezentacijaViewList=new LinkedList<>();
        prezList=new LinkedList<>();
        this.removeAll();
        this.p=p;
        this.p.addSubscriber(this);
        // Setting the JTabbedPane Position and Layout as Wrap
        this.setLayout(new BorderLayout());
        tabs = new JTabbedPane(JTabbedPane.NORTH);
        ime=new JLabel(p.getName(), SwingConstants.CENTER);
        // slajdView = new SlajdView();
        // Adding user defined pannels to JTabbedPane
        for(int i=0;i<p.getChildren().size();i++) {
            prezList.add((Prezentacija)p.getChildAt(i));
            PrezentacijaView component=new PrezentacijaView((Prezentacija)p.getChildAt(i));
            tabs.addTab(p.getChildAt(i).getName(),component);
            p.getChildAt(i).addSubscriber(this);
        }
        add(ime,BorderLayout.NORTH);
        add(tabs,BorderLayout.CENTER);
    }
    @Override
    public void update(Object notification) {
        if(notification instanceof Project) {
            ime.setText(((Project) notification).getName());
            if(prezList.size()<((Project)notification).getChildren().size()){
                for(int i =0;i<(((Project) notification).getChildren().size());i++) {
                    if(!prezList.contains(((Project)notification).getChildAt(i))){
                        prezList.add((Prezentacija) ((Project) notification).getChildAt(i));
                        ((Project) notification).getChildAt(i).addSubscriber(this);
                        PrezentacijaView component=new PrezentacijaView((Prezentacija) ((Project) notification).getChildAt(i));
                        tabs.addTab(((Project) notification).getChildAt(i).getName(),component);
                    }
                }
            }else {
                for (int i = 0; i < prezList.size(); i++) {
                    if (!((Project) notification).getChildren().contains(prezList.get(i))) {
                        System.out.println("usliiiiiiiiii");
                        prezList.remove(i);
                        tabs.remove(i);
                    }
                }
            }
            /*boolean pronasao=false;
            for(int i=0;i<prezentacijaViewList.size();i++){
                if((((Project) notification).getChildren()).contains(prezentacijaViewList.get(i))){//losa logika pokusaj fixa da observer nije ovoliko komplikovan
                    pronasao=true;
                    prezentacijaViewList.remove(i);
                    tabs.remove(i);
                    break;
                }
            }
                if(((Project) notification).getChildren().size()!=0) {
                    if (pronasao == false) {
                        PrezentacijaView component=new PrezentacijaView((Prezentacija) ((Project) notification).getChildAt(((Project) notification).getChildren().size() - 1));
                        prezentacijaViewList.add(component);
                        tabs.add(component.getP().getName(),component);
                    }
                }*/
            }else if(notification instanceof Prezentacija) {
            for(int i=0;i<prezList.size();i++){
                if(prezList.get(i).equals(notification)){
                    System.out.println("ZZZZZZZZZZZZZZ");
                    tabs.setTitleAt(i,((Prezentacija) notification).getName());
                }
            }
        }
    }
    public PrezentacijaView selektovanTab(){
        return (PrezentacijaView) tabs.getSelectedComponent();
    }

    public Project getP() {
        return p;
    }
}

