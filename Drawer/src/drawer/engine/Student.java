package drawer.engine;

import drawer.gui.alert.Alert;
import java.io.*;

/**
 *
 * @author Alex Miccio
 */
public class Student implements Serializable
{
    private String name;
    private int number;
    private String surname;

    public Student(String name, int number, String surname)
    {
        if(name.length() <= 0)
            new Alert("The length of student's name must be positive").setVisible(true);
        this.name = name;
        if(number <= 0)
            new Alert("The student's number must be positive").setVisible(true);
        this.number = number;
        if(surname.length() <= 0)
            new Alert("The length of student's surname must be positive").setVisible(true);
        this.surname = surname;
    }

    public String getName()
    {
        return name;
    }

    public int getNumber()
    {
        return number;
    }

    public String getSurname()
    {
        return surname;
    }

    @Override public String toString()
    {
        return "Numero: " + this.number + ", Cognome: " + this.surname + ", Nome: " + this.name;
    }
}