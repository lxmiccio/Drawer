package drawer.gui.alert;

import javax.swing.*;

/**
 *
 * @author Alex Miccio
 */
public class Alert extends JDialog
{
    private JButton btnExit;
    private JLabel lblError;
    
    public Alert(String error)
    {
        if(error.length() <= 0)
            new Alert("Error's length must be positive").setVisible(true);
        this.btnExit = new JButton("Exit");
        this.lblError = new JLabel(error);
        this.lblError.setHorizontalAlignment(SwingConstants.CENTER);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(this.btnExit, 200, 200, 200)
                    .addComponent(this.lblError, 200, 200, 200)
                )
                .addGap(20, 20, 20)
            )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(this.lblError, 25, 25, 25)
                .addGap(30, 30, 30)
                .addComponent(this.btnExit, 25, 25, 25)
                .addGap(20, 20, 20)
            )
        );
        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setResizable(false);
        this.setTitle("Error");
        AlertListener alertListener = new AlertListener(this.btnExit);
        this.addWindowListener(alertListener);
        this.btnExit.addActionListener(alertListener);
    }
}