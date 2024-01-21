package app.gui.Swing.action;

import app.gui.Swing.tree.view.SlotTekstEditor;

public class ActionManager {

    private InfoAction infoAction;
    private NewProjectAction newProjectAction;
    private EditAction editAction;
    private PrezentacijaEditAction prezentacijaEditAction;
    private RemoveAction removeAction;
    private EditPaneAction editPaneAction;
    private SlideshowPaneAction slideshowPaneAction;
    private EditStateAddAction editStateAddAction;
    private EditStateDeleteAction editStateDeleteAction;
    private EditStateMoveAction editStateMoveAction;
    private EditStateSelectAction editStateSelectAction;
    private SetColorAction setColorAction;
    private UndoAction undoAction;
    private RedoAction redoAction;
    private SaveAsAction saveAsAction;
    private OpenProjectAction openProjectAction;
    private SaveAction saveAction;
    private SharePrezentacijaAction sharePrezentacijaAction;
    private CopyPrezentacijaAction copyPrezentacijaAction;

    public ActionManager(){
        initialiseAction();
    }
    private void initialiseAction(){
        infoAction= new InfoAction();
        newProjectAction=new NewProjectAction();
        editAction=new EditAction();
        prezentacijaEditAction =new PrezentacijaEditAction();
        removeAction=new RemoveAction();
        editPaneAction=new EditPaneAction();
        slideshowPaneAction=new SlideshowPaneAction();
        editStateAddAction=new EditStateAddAction();
        editStateDeleteAction=new EditStateDeleteAction();
        editStateMoveAction=new EditStateMoveAction();
        editStateSelectAction=new EditStateSelectAction();
        setColorAction=new SetColorAction();
        undoAction=new UndoAction();
        redoAction=new RedoAction();
        saveAsAction =new SaveAsAction();
        openProjectAction=new OpenProjectAction();
        saveAction=new SaveAction();
        sharePrezentacijaAction=new SharePrezentacijaAction();
        copyPrezentacijaAction=new CopyPrezentacijaAction();
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }

    public NewProjectAction getNewProjectAction() {
        return newProjectAction;
    }

    public EditAction getEditAction() {
        return editAction;
    }

    public PrezentacijaEditAction getPrezentacijaEditAction() {
        return prezentacijaEditAction;
    }

    public RemoveAction getRemoveAction() {
        return removeAction;
    }

    public EditPaneAction getEditPaneAction() {
        return editPaneAction;
    }

    public SlideshowPaneAction getSlideshowPaneAction() {
        return slideshowPaneAction;
    }

    public EditStateAddAction getEditStateAddAction() {
        return editStateAddAction;
    }

    public EditStateDeleteAction getEditStateDeleteAction() {
        return editStateDeleteAction;
    }

    public EditStateMoveAction getEditStateMoveAction() {
        return editStateMoveAction;
    }

    public EditStateSelectAction getEditStateSelectAction() {
        return editStateSelectAction;
    }

    public SetColorAction getSetColorAction() {
        return setColorAction;
    }

    public UndoAction getUndoAction() {
        return undoAction;
    }

    public RedoAction getRedoAction() {
        return redoAction;
    }

    public SaveAction getSaveAction() {
        return saveAction;
    }

    public OpenProjectAction getOpenProjectAction() {
        return openProjectAction;
    }

    public SaveAsAction getSaveAsAction() {
        return saveAsAction;
    }

    public SharePrezentacijaAction getSharePrezentacijaAction() {
        return sharePrezentacijaAction;
    }

    public CopyPrezentacijaAction getCopyPrezentacijaAction() {
        return copyPrezentacijaAction;
    }
}
