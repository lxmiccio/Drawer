package drawer.gui.alert;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Alex Miccio
 */
public class AlertListener implements ActionListener, WindowListener
{
    private JButton btnExit;

    public AlertListener(JButton btnExit)
    {
        if(btnExit == null)
            new Alert("BtnExit cannot be null").setVisible(true);
        this.btnExit = btnExit;
    }

    @Override public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == this.btnExit)
            System.exit(0);
    }

    @Override public void windowOpened(WindowEvent e)
    {
    }

    @Override public void windowClosing(WindowEvent e)
    {
    }

    @Override public void windowClosed(WindowEvent windowEvent)
    {
        System.exit(0);
    }

    @Override public void windowIconified(WindowEvent windowEvent)
    {
    }

    @Override public void windowDeiconified(WindowEvent windowEvent)
    {
    }

    @Override public void windowActivated(WindowEvent windowEvent)
    {
    }

    @Override public void windowDeactivated(WindowEvent windowEvent)
    {
    }
}