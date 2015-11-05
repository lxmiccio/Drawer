package drawer.gui.extracted;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Alex Miccio
 */
public class Drawn extends JFrame
{
    private ArrayList<DrawnStudent> drawnStudents;
    private JPanel pnlScrProducts;
    private JScrollPane scrProducts;

    public Drawn()
    {
        this.drawnStudents = new ArrayList<>();

        this.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        this.pnlScrProducts = new JPanel();

        this.scrProducts = new JScrollPane();
        this.scrProducts.setPreferredSize(new Dimension(500, 500));
        this.scrProducts.setViewportBorder(null);
        this.scrProducts.setViewportView(this.pnlScrProducts);
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(15, 15, 15, 15);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        this.add(this.scrProducts, gridBagConstraints);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Drawn Student");
    }

    public void addDrawnStudent(DrawnStudent drawnStudent)
    {
        this.drawnStudents.add(drawnStudent);
        this.pnlScrProducts.add(drawnStudent);
        this.pnlScrProducts.setLayout(new GridLayout(this.drawnStudents.size(), 1));
        this.pnlScrProducts.revalidate();
    }

    public ArrayList<DrawnStudent> getDrawnStudents()
    {
        return drawnStudents;
    }

    public JPanel getPnlScrProducts()
    {
        return pnlScrProducts;
    }

    public JScrollPane getScrProducts()
    {
        return scrProducts;
    }
}