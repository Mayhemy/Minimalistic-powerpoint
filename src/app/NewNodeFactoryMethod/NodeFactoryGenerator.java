package app.NewNodeFactoryMethod;

import app.Tree.Model.Prezentacija;
import app.Tree.Model.Project;
import app.Tree.Model.Workspace;
import app.gui.Swing.tree.model.MyTreeNode;

public class NodeFactoryGenerator {
    static final ProjectFactory projectFactory=new ProjectFactory();
    static final PrezentacijaFactory prezentacijaFactory=new PrezentacijaFactory();
    static final SlajdFactory slajdFactory=new SlajdFactory();

    public static AbstractNodeFactory returnNodeFactory(MyTreeNode selected){
        if(selected.getNode() instanceof Workspace){
            return projectFactory;
        }else if(selected.getNode() instanceof Project){
            return prezentacijaFactory;
        }else if(selected.getNode() instanceof Prezentacija){
            return slajdFactory;
        }
        return null;
    }
}
