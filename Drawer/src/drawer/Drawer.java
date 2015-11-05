package drawer;

import drawer.gui.Menu;
import drawer.engine.Classe;
import drawer.engine.Subject;
import drawer.engine.Student;

/**
 *
 * @author Alex Miccio
 */
public class Drawer
{
    private Classe classe;
    private Menu menu;

    public Drawer()
    {
        this.classe = new Classe(this, "5Ainf");

        classe.addSubject(new Subject(classe, "Matematica"));

        classe.addStudent(new Student("Lorenzo", 1, "Alberetti"));
        classe.addStudent(new Student("Federico", 2, "Alunni Proietti"));
        classe.addStudent(new Student("Roland Pristene", 3, "Boga"));
        classe.addStudent(new Student("Federico", 4, "Braconi"));
        classe.addStudent(new Student("Cristiano", 5, "Capretta"));
        classe.addStudent(new Student("Lorenzo", 6, "Carfagna"));
        classe.addStudent(new Student("Axel", 7, "Casagrande Cuppoloni"));
        classe.addStudent(new Student("Alessandro", 8, "De Angelis"));
        classe.addStudent(new Student("Caterina Elisabetta", 9, "Eracli Verità"));
        classe.addStudent(new Student("Simone", 10, "Ficola"));
        classe.addStudent(new Student("Lorenzo", 11, "Gazzella"));
        classe.addStudent(new Student("Andrea", 12, "Germini"));
        classe.addStudent(new Student("Fabio", 13, "Giannoni"));
        classe.addStudent(new Student("Luca", 14, "Giovannetti"));
        classe.addStudent(new Student("Andrei", 15, "Leca"));
        classe.addStudent(new Student("Luna", 16, "Pierferdinando"));
        classe.addStudent(new Student("Alex", 17, "Miccio"));
        classe.addStudent(new Student("Giulio", 18, "Mommi"));
        classe.addStudent(new Student("Matteo", 19, "Moschini"));
        classe.addStudent(new Student("Giulio", 20, "Paparelli"));
        classe.addStudent(new Student("Gabriele", 21, "Quirini"));
        classe.addStudent(new Student("Simone", 22, "Raichini"));
        classe.addStudent(new Student("Riccardo", 23, "Sforza"));
        classe.addStudent(new Student("Marco", 24, "Sargenti"));
        classe.addStudent(new Student("Luca", 25, "Temperoni"));

        this.menu = new Menu(this);
        this.menu.setVisible(true);
    }

    public Classe getClasse()
    {
        return classe;
    }

    public Menu getMenu()
    {
        return menu;
    }
}