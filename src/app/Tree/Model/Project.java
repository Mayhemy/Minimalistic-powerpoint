package app.Tree.Model;

import app.Observer.Subscriber;

import java.io.File;
import java.io.Serializable;

public class Project extends RuNodeComp implements Serializable, Subscriber {

    private transient boolean changed;
    private File projectFile;
    private static int brojac=0;
    private boolean importovan;

    public Project() {
        this.changed=true;
        this.projectFile=null;
        this.importovan=false;
        brojac++;
    }

    public Project(String name, RuNode parent) {
        super(name,parent);
        brojac++;
    }

    public Project(RuNode parent){
        super(parent);
        brojac++;
    }

    public boolean isChanged() {
        return changed;
    }

    public File getProjectFile() {
        return projectFile;
    }


    public void setProjectFile(File projectFile) {
        this.projectFile = projectFile;
    }


    public void setChanged(boolean changed) {
        if (this.changed!=changed){
            this.changed=changed;
        }
        if(name.startsWith("*") && !changed){
            normalizeName();
        }
    }

    @Override
    public void update(Object notification) {
        setChanged(true);
        if(!(name.startsWith("*")))
            setName((changed?"*":"")+ name);
        else{
            if(!changed){
                setName(name.substring(1));
            }
        }
    }

    public static int getBrojac() {
        return brojac;
    }

    private void normalizeName(){
        setName(name.substring(1));
    }

    public void incBrojac(){
        brojac++;
    }

    public boolean isImportovan() {
        return importovan;
    }

    public void setImportovan(boolean importovan) {
        this.importovan = importovan;
    }
}
