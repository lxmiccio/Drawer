package drawer.engine;

import drawer.gui.alert.Alert;
import drawer.gui.extracted.Drawn;
import drawer.gui.extracted.DrawnStudent;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.swing.ImageIcon;

/**
 *
 * @author Alex Miccio
 */
public class Subject
{
    private Classe classe;
    private Drawn drawn;
    private ArrayList<Student> drawnStudents;
    private File file;
    private String name;

    public Subject(Classe classe, String name)
    {
        if(classe == null)
            new Alert("Classe cannot be null").setVisible(true);
        this.classe = classe;
        if(name.length() <= 0)
            new Alert("The length of subject's name must be positive").setVisible(true);
        this.name = name;
        this.drawn = new Drawn();
        this.drawn.setVisible(true);
        this.drawnStudents = new ArrayList<>();
        this.file = new File(Paths.get(".").toAbsolutePath().normalize() + "\\rsc\\" + name + ".dat");
        if(!this.file.exists())
            try
            {
                this.file.createNewFile();
            }
            catch(IOException exception)
            {
            }
        else
        {
            FileInputStream fileInputStream = null;
            ObjectInputStream objectInputStream = null;
            try
            {
                fileInputStream = new FileInputStream(this.file);
            }
            catch (FileNotFoundException exception)
            {
                System.err.println("Cannot find " + this.name);
                if(!file.exists())
                    try
                    {
                        System.out.println("s");
                        file.createNewFile();
                    }
                    catch(IOException iOException)
                    {
                        System.err.println("Cannot create " + name);
                    }
                System.out.println(name + " has now been created");
            }
            finally
            {
                try
                {
                    do
                    {
                        objectInputStream = new ObjectInputStream(fileInputStream);
                        this.drawnStudents.add((Student) objectInputStream.readObject());
                    }
                    while(true);
                }
                catch (EOFException exception)
                {
                    if(objectInputStream != null)
                        try
                        {
                            objectInputStream.close();
                        }
                        catch (IOException ex)
                        {
                            System.out.println("Cannot close ObjectInputStream");
                        }
                }
                catch (ClassNotFoundException | IOException exception)
                {
                    System.err.println("Cannot read " + this.name);
                }
                finally
                {
                    if(objectInputStream != null)
                        try
                        {
                            objectInputStream.close();
                        }
                        catch (IOException ex)
                        {
                            System.out.println("Cannot close ObjectInputStream");
                        }
                }
            }
        }
    }

    public void addDrawnStudent(Student student)
    {
        if(!this.isStudentAlreadyDrawn(student.getNumber()))
        {
            this.drawnStudents.add(student);
            ObjectOutputStream objectOutputStream = null;
            try
            {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(file.getPath(), true));
                objectOutputStream.writeObject(student);
                objectOutputStream.flush();
            }
            catch(IOException exception)
            {
                System.err.println("Cannot add customer to " + this.file.getName());
            }
            finally
            {
                if(objectOutputStream != null)
                    try
                    {
                        objectOutputStream.close();
                    }
                    catch (IOException exception)
                    {
                        System.err.println("Cannot close ObjectOutputStream");
                    }
            }
        }
        else
        {
            System.err.println("Student already drawn");
        }
    }

    public void drawStudents(int number)
    {
        Random random = new Random();
        for(int i = 0; i < number;)
        {
            if(this.isAnyStudentAvailable())
            {
                Student drawnStudent = this.classe.getStudents().get(random.nextInt(this.classe.getStudents().size()));
                if(!this.isStudentAlreadyDrawn(drawnStudent.getNumber()))
                {
                    System.out.println("È Stato Estratto " + drawnStudent);
                    this.addDrawnStudent(drawnStudent);
                    this.drawn.addDrawnStudent(new DrawnStudent(new ImageIcon(), drawnStudent.getSurname() + " " + drawnStudent.getName()));
                    i++;
                }
            }
            else
            {
                this.drawnStudents.clear();
                if(this.file.exists())
                    try
                    {
                        Files.delete(this.file.toPath());
                    }
                    catch(IOException exception)
                    {
                        System.err.println("Cannot delete " + this.file.getName() + ".dat");
                    }
                try
                {
                    this.file.createNewFile();
                }
                catch(IOException iOException)
                {
                    System.err.println("Cannot create " + this.file.getName() + ".dat");
                }
            }
            
        }
    }
    
    public String getName()
    {
        return name;
    }

    public ArrayList<Student> getStudents()
    {
        return drawnStudents;
    }
    
    public boolean isAnyStudentAvailable()
    {
        boolean available = false;
        if(this.classe.getStudents().size() - this.drawnStudents.size() > 0)
            available = true;
        return available;
    }
    
    public boolean isStudentAlreadyDrawn(int number)
    {
        boolean drawn = false;
        for (Student studentDrawn : this.drawnStudents)
            if(studentDrawn.getNumber() == number)
                drawn = true;
        return drawn;
    }
}