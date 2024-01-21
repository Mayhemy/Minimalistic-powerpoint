package app.PrezViewState.concrete;

import app.gui.Swing.tree.view.PrezentacijaView;
import app.PrezViewState.PaneState;

public class EditState implements PaneState {
    @Override
    public void play(PrezentacijaView PView) {
        PView.setContentPaneEdit();
    }
}
