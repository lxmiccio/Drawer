package drawer;

import java.io.*;
import java.nio.file.*;
import javax.swing.*;

/**
 *
 * @author Alex Miccio
 */
public class Main
{
    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, UnsupportedLookAndFeelException
    {
        for(UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            if("Windows".equals(info.getName()))
                UIManager.setLookAndFeel(info.getClassName());

        File directory = new File(Paths.get(".").toAbsolutePath().normalize() + "\\rsc");
        if (!directory.exists())
            if (!directory.mkdir())
                throw new IllegalArgumentException("Cannot Create Directory " + directory.getName());

        Drawer drawer = new Drawer();
    }
}