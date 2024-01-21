package app.NewNodeFactoryMethod;

import app.Tree.Model.RuNode;
import app.Tree.Model.Slajd;

public class SlajdFactory extends AbstractNodeFactory{
    @Override
    protected RuNode createNode() {
        return new Slajd();
    }
}
