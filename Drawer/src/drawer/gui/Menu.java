package drawer.gui;

import drawer.gui.alert.Alert;
import drawer.engine.Subject;
import drawer.Drawer;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Alex Miccio
 */
public class Menu extends JFrame
{
    private JButton btn;
    private JComboBox cmbNumber;
    private JComboBox cmbSubject;
    private Drawer extractor;
    private JLabel lblNumber;
    private JLabel lblSubject;

    public Menu(Drawer extractor)
    {
        if(extractor == null)
            new Alert("Extractor cannot be null").setVisible(true);
        this.extractor = extractor;

        this.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        this.btn = new JButton("Estrai");
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(15, 30, 30, 30);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        this.add(this.btn, gridBagConstraints);

        this.cmbNumber = new JComboBox();
        for(int i = 1; i <= this.extractor.getClasse().getStudents().size(); i++)
            this.cmbNumber.addItem(i);
        ((JLabel)this.cmbNumber.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(15, 30, 15, 30);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        this.add(this.cmbNumber, gridBagConstraints);

        this.cmbSubject = new JComboBox();
        for(Subject subject : this.extractor.getClasse().getSubjects())
            this.cmbSubject.addItem(subject.getName());
        ((JLabel)this.cmbSubject.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(15, 30, 15, 30);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        this.add(this.cmbSubject, gridBagConstraints);

        this.lblNumber = new JLabel("Inserire Il Numero Di Studenti Da Estrarre");
        this.lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(15, 30, 15, 30);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        this.add(this.lblNumber, gridBagConstraints);

        this.lblSubject = new JLabel("Inserire La Materia Per La Quale Verranno Estratti Gli Studenti");
        this.lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(30, 30, 15, 30);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        this.add(this.lblSubject, gridBagConstraints);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Error");

        MenuListener menuListener = new MenuListener(this.btn, this.extractor.getClasse(), this.cmbNumber, this.cmbSubject);
        this.btn.addActionListener(menuListener);
    }
}