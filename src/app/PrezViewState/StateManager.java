package app.PrezViewState;

import app.PrezViewState.concrete.EditState;
import app.PrezViewState.concrete.SlideshowState;

public class StateManager {
    private PaneState currentState;
    private EditState editState;
    private SlideshowState slideshowState;

    public StateManager() {
        initStates();
    }

    private void initStates() {
        editState = new EditState();
        slideshowState = new SlideshowState();
        currentState = editState;
    }

    public PaneState getCurrentState() {
        return currentState;
    }

    public void setEditState() {
        this.currentState = editState;
    }

    public void setSlideshowState() {
        this.currentState = slideshowState;
    }
}
