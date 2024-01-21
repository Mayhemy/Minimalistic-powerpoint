package app.gui.Swing.action;

import app.gui.Swing.tree.view.SlotTekstEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnderlineTextListener implements ActionListener {
    SlotTekstEditor ste;
    public UnderlineTextListener(SlotTekstEditor STE) {
        this.ste=STE;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String substr="";
        if((substr=ste.getField().getSelectedText())!=null){
            String text=ste.getField().getText();
            int pocetak=text.indexOf(substr);
            int kraj=pocetak+substr.length()+1;
            StringBuilder sb = new StringBuilder(text);
            sb.insert(pocetak, "`");
            sb.insert(kraj,"`");
            String finalni=sb.toString();
            ste.getField().setText(finalni);
        }
    }
}
