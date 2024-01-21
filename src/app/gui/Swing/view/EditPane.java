package app.gui.Swing.view;

import app.Error.ErrorFactory;
import app.Error.MojError;
import app.Observer.Subscriber;
import app.Tree.Model.Workspace;
import app.command.CommandManager;
import app.gui.Swing.tree.model.MyModel;
import app.gui.Swing.tree.model.MyTreeNode;
import app.gui.Swing.tree.view.MyJTree;
import app.gui.Swing.tree.view.WorkspaceView;

import javax.swing.*;
import java.awt.*;

public class EditPane extends JPanel implements Subscriber {
    private static EditPane instance=null;
    private Toolbar toolbar;
    private MyJTree workspaceTree;
    private WorkspaceView workspaceView;
    private ErrorFactory errorFactory;
    private CommandManager cmdManager;
    private EditPane(){

    }
    private void initialise(){
        initialiseMyJTree();
        initialiseMyWorkspaceView();
        initialiseModel();
        initialiseGUI();
        initialiseErrorFactory();
        initialiseCommandManager();
    }
    private void initialiseGUI(){
        Toolkit tk= Toolkit.getDefaultToolkit();
        Dimension screenSize= tk.getScreenSize();
        int windowHeight=screenSize.height/2;
        int windowWidth=screenSize.width/2;
        setSize(windowWidth,windowHeight);
        setLayout(new BorderLayout());

        toolbar=new Toolbar();
        add(toolbar,BorderLayout.NORTH);

        JPanel treePane = new JPanel();
        treePane.add(workspaceTree);
        JPanel workPane = new JPanel();
        workPane.setLayout(new BorderLayout(0,0));
        workPane.add(workspaceView);
        JScrollPane treeScrollPane = new JScrollPane(treePane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JSplitPane mainSp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,treeScrollPane,workPane);
        mainSp.setDividerLocation(windowWidth/5);
        add(mainSp,BorderLayout.CENTER);
    }
    private void initialiseMyJTree(){
        workspaceTree=new MyJTree(new MyModel());

    }
    private void initialiseErrorFactory(){
        errorFactory=ErrorFactory.getInstance();
        errorFactory.addSubscriber(this);
    }
    private void initialiseMyWorkspaceView(){
        workspaceView= WorkspaceView.getInstance();
    }
    public static EditPane getInstance() {
        if (instance == null) {
            instance = new EditPane();
            instance.initialise();
        }
        return instance;
    }

    public void initialiseCommandManager(){
        cmdManager=new CommandManager();
    }
    public MyJTree getMyJTree() {
        return workspaceTree;
    }

    @Override
    public void update(Object notification) {
        System.out.println("Desio se update!!!!!!\n");
        new JOptionPane().showMessageDialog(instance,((MojError)notification).getText());
    }

    public WorkspaceView getWorkspaceView() {
        return workspaceView;
    }
    public void initialiseModel(){
        this.workspaceView.setWorkspace((Workspace)((MyTreeNode)this.workspaceTree.getModel().getRoot()).getNode());
    }

    public CommandManager getCmdManager() {
        return cmdManager;
    }

    public MyJTree getWorkspaceTree() {
        return workspaceTree;
    }
}
