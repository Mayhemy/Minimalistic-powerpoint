package app.gui.Swing.action;

import app.Error.ErrorFactory;
import app.Tree.Model.TipSlota;
import app.gui.Swing.tree.view.ColorPickerDialog;
import app.gui.Swing.tree.view.PrezentacijaView;
import app.gui.Swing.view.EditPane;
import app.gui.Swing.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetColorPotvrdiListener implements ActionListener {
    ColorPickerDialog cpd;
    public SetColorPotvrdiListener(ColorPickerDialog cpDialog) {
        this.cpd=cpDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object z= ((EditPane) MainFrame.getInstance().getActivePane()).getWorkspaceView().getTrenutni().selektovanTab();
        String red=cpd.getR();
        String blue=cpd.getB();
        String green=cpd.getG();
        String borderWidth=cpd.getBorderWidth();
        String borderDashLength=cpd.getBorderDashLength();
        String handler=cpd.getCb().getSelectedItem().toString().toLowerCase();
        if(red.isEmpty()){
            red=Integer.toString(0);
        }
        if(blue.isEmpty()){
            blue=Integer.toString(0);
        }
        if(green.isEmpty()){
            green=Integer.toString(0);
        }
        if(borderWidth.isEmpty()){
            borderWidth=Integer.toString(0);
        }
        if(borderDashLength.isEmpty()){
            borderDashLength=Integer.toString(0);
        }

        if((Integer.parseInt(red)>255 || Integer.parseInt(red)<0) || (Integer.parseInt(blue)>255 || Integer.parseInt(blue)<0) || (Integer.parseInt(green)>255 || Integer.parseInt(green)<0) || (Integer.parseInt(borderDashLength)<0) || (Integer.parseInt(borderWidth))<0 ){
            ErrorFactory.getInstance().baciError("ErrorWrongColorValue");
        }else {
            if (z instanceof PrezentacijaView) {
               ((PrezentacijaView) z).getStateEditSlideManager().getCurrentState().setFill(new Color(Integer.parseInt(red),Integer.parseInt(blue),Integer.parseInt(green)));
                ((PrezentacijaView) z).getStateEditSlideManager().getCurrentState().setBorderWidth(Integer.parseInt(borderWidth));
                ((PrezentacijaView) z).getStateEditSlideManager().getCurrentState().setDashLength(Integer.parseInt(borderDashLength));
                if(handler.equals("textslothandler")){
                    ((PrezentacijaView) z).getStateEditSlideManager().getCurrentState().setTipSLota(TipSlota.Text);
                }else if(handler.equals("multimediaslothandler")){
                    ((PrezentacijaView) z).getStateEditSlideManager().getCurrentState().setTipSLota(TipSlota.Slika);
                }
            }
        }
        cpd.setVisible(false);
        SwingUtilities.updateComponentTreeUI(((EditPane)MainFrame.getInstance().getActivePane()).getMyJTree());
    }
}
