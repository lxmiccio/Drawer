package drawer.gui.extracted;

import drawer.gui.alert.Alert;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Alex Miccio
 */
public class DrawnStudent extends JPanel
{
    private JLabel lblFace;
    private JLabel lblName;

    public DrawnStudent(ImageIcon imageIcon, String name)
    {
        if(imageIcon == null)
            new Alert("Classe cannot be null").setVisible(true);
        this.lblFace = new JLabel(imageIcon);
        //this.lblFace = new JLabel(new ImageIcon(imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        
        if(name.length() <= 0)
            new Alert("The length of student's name must be positive").setVisible(true);
        this.lblName = new JLabel(name);
        this.lblName.setHorizontalAlignment(SwingConstants.CENTER);

        this.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(15, 15, 15, 15);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        this.add(this.lblFace, gridBagConstraints);

        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(15, 15, 15, 15);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        this.add(this.lblName, gridBagConstraints);
    }

    public JLabel getLblFace()
    {
        return lblFace;
    }

    public JLabel getLblName()
    {
        return lblName;
    }
}