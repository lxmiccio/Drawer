package drawer.engine;

import drawer.Drawer;
import drawer.gui.alert.Alert;
import java.util.*;

/**
 *
 * @author Alex Miccio
 */
public class Classe
{
    private String name;
    private Drawer extractor;
    private ArrayList<Student> students;
    private ArrayList<Subject> subjects;

    public Classe(Drawer extractor, String name)
    {
        if(extractor == null)
            new Alert("Extractor cannot be null").setVisible(true);
        this.extractor = extractor;
        if(name.length() <= 0)
            new Alert("The length of subject's name must be positive").setVisible(true);
        this.name = name;
        this.students = new ArrayList<>();
        this.subjects = new ArrayList<>();
    }
    
    public void addStudent(Student student)
    {
        this.students.add(student);
    }
    
    public void addSubject(Subject subject)
    {
        this.subjects.add(subject);
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Student> getStudents()
    {
        return students;
    }

    public ArrayList<Subject> getSubjects()
    {
        return subjects;
    }
}