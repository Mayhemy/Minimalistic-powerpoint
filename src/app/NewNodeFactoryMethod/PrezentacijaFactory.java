package app.NewNodeFactoryMethod;

import app.Tree.Model.Prezentacija;
import app.Tree.Model.RuNode;

public class PrezentacijaFactory extends AbstractNodeFactory {
    @Override
    protected RuNode createNode() {
        return new Prezentacija();
    }
}
