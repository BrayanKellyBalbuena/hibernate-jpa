import edu.itla.hibernatejpa.model.Author;
import edu.itla.hibernatejpa.model.Book;
import edu.itla.hibernatejpa.model.Direction;
import edu.itla.hibernatejpa.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestEmployee {
    private static EntityManager manager;
    private static EntityManagerFactory emf;

    public static void main(String[]args){
        emf = Persistence.createEntityManagerFactory("Persistence");
        manager = emf.createEntityManager();


//        createAuthorBook();
//        printBooksByAuthor(1L);
//        printAllAuthor();
//        printAllAuthorBooks();
      // printAllEmployee();
//      findEmployee(1l);
//        createEmployeeDirection();
//        updateEmployee( new Employee(1L, "Change Name", "Doe",
//                LocalDate.of(1995, 01, 23),
//                new Direction(1l)));
//        findEmployee(1l);
//        delete(1l);
//        find(1l);
    }

    public static void beginTransaction(){
        manager.getTransaction().begin();
    }

    public static void createEmployeeDirection(){
        beginTransaction();
        Employee emp= new Employee(1L, "test",
                "test", LocalDate.of(1999, 5, 23)
                ,new Direction(1L, "direcction", "DO",
                "SANTO DOMINGO", "Rep.Dom"));
        manager.persist(emp);
        closeTransaction();
    }

    public static void closeTransaction(){
        manager.getTransaction().commit();
    }

    public static void createAuthorBook(){
        beginTransaction();
        Author author = new Author(1L, "Brayan", "Dom");
        Author author1 = new Author(2L, "Author1", "Dom.Rep");
        Author author2 = new Author(3L, "Author2", "Dom");

        Book book1 = new Book(1L, author, "Book of Author");
        Book book2 = new Book(2L, author, "Book of Author");
        Book book3 = new Book(3L, author1, "Book of Author1");
        Book book4 = new Book(4L, author1, "Book of Author1");
        Book book5 = new Book(5L, author2, "Book of Author2");

        author.setBooks(new HashSet<Book>(){{
            add(book1);
            add(book2);

        }});

        author1.setBooks(new HashSet<Book>(){{
            add(book3);
            add(book4);
        }});

        author2.setBooks(new HashSet<Book>(){{
            add(book5);
        }});

        manager.persist(book1);
        manager.persist(book2);
        manager.persist(book3);
        manager.persist(book4);
        manager.persist(book5);
        closeTransaction();

    }

    public static void printBooksByAuthor(long id)
    {
        Author author = manager.find(Author.class, id);
        Set<Book> books = author.getBooks();

        for(Book book : books){
            System.out.println(book);
        }
    }

    public static void printAllAuthorBooks()
    {
        Set<Book> books;
        books = (HashSet<Book>) manager.createQuery("from Book").getResultList()
                .stream().collect(Collectors.toSet());

        System.out.println("In this database have:" + books.size());
        for(Book book : books){
            System.out.println(book);
        }
    }


    public static void printAllAuthor()
    {
        List<Author> authors;
        authors = (List<Author>) manager.createQuery("from Author").getResultList();

        System.out.println("In this database have:" + authors.size());
        for(Author author : authors){
            System.out.println(author);
        }
    }

    public static void printAllEmployee()
    {
        List<Employee> employees;
        employees = (List<Employee>) manager.createQuery("from Employee").getResultList();

        System.out.println("In this database have:" + employees.size());
        for(Employee emp : employees){
            System.out.println(emp);
        }
    }

    public static void findEmployee(long id){
        Employee emp = manager.find(Employee.class, id);
        System.out.println(emp);
    }

    public static void updateEmployee(Employee emp){
        beginTransaction();
        Employee tempEmployee = manager.find(Employee.class, emp.getId());
        tempEmployee.setName(emp.getName());
        tempEmployee.setLastName(emp.getLastName());
        tempEmployee.setBirthDate(emp.getBirthDate());
        closeTransaction();

    }

    public static void deleteEmployee(long id){
        beginTransaction();
        manager.remove(manager.find(Employee.class, id));
        closeTransaction();
    }
}
