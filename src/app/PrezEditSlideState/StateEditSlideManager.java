package app.PrezEditSlideState;

import app.PrezEditSlideState.concrete.AddSlotState;
import app.PrezEditSlideState.concrete.DeleteSlotState;
import app.PrezEditSlideState.concrete.MoveSlotState;
import app.PrezEditSlideState.concrete.SelectSlotState;

public class StateEditSlideManager {
    AbstractEditSlideState currentState;
    AddSlotState addSlotState;
    DeleteSlotState deleteSlotState;
    MoveSlotState moveSlotState;
    SelectSlotState selectSlotState;

    public StateEditSlideManager() {
        addSlotState=new AddSlotState();
        deleteSlotState=new DeleteSlotState();
        moveSlotState=new MoveSlotState();
        selectSlotState=new SelectSlotState();
        currentState=addSlotState;
    }

    public AbstractEditSlideState getCurrentState() {
        return currentState;
    }

    public void setAddSlotState() {
        this.currentState = addSlotState;
    }

    public void setDeleteSlotState() {
        this.currentState = deleteSlotState;
    }

    public void setMoveSlotState() {
        this.currentState = moveSlotState;
    }

    public void setSelectSlotState() {
        this.currentState = selectSlotState;
    }
}
