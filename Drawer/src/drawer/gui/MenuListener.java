package drawer.gui;

import drawer.gui.alert.Alert;
import drawer.engine.Classe;
import drawer.engine.Subject;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Alex Miccio
 */
public class MenuListener implements ActionListener
{
    private JButton btn;
    private Classe classe;
    private JComboBox cmbNumber;
    private JComboBox cmbSubject;

    public MenuListener(JButton btn, Classe classe, JComboBox cmbNumber, JComboBox cmbSubject)
    {
        if(btn == null)
            new Alert("Btn cannot be null").setVisible(true);
        this.btn = btn;
        if(classe == null)
            new Alert("Classe cannot be null").setVisible(true);
        this.classe = classe;
        if(cmbNumber == null)
            new Alert("CmbNumber cannot be null").setVisible(true);
        this.cmbNumber = cmbNumber;
        if(cmbSubject == null)
            new Alert("CmbSubject cannot be null").setVisible(true);
        this.cmbSubject = cmbSubject;
    }

    @Override public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == this.btn)
            for(Subject subject : this.classe.getSubjects())
                if(subject.getName().equals(this.cmbSubject.getSelectedItem()))
                    subject.drawStudents((int)this.cmbNumber.getSelectedItem());
    }
}