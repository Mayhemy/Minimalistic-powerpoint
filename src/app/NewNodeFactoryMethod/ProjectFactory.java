package app.NewNodeFactoryMethod;

import app.Tree.Model.Project;
import app.Tree.Model.RuNode;

public class ProjectFactory extends AbstractNodeFactory{
    @Override
    protected RuNode createNode() {
        return new Project();
    }
}
