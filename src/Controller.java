import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;
import java.util.Scanner;

public class Controller implements AutoCloseable {

    private HibernateContext model = new HibernateContext();

    @Override
    public void close() throws Exception {
        model.close();
    }


    public void addNewBook(String title, String author, String isbn) {
        Book b = new Book();
        b.setTitle(title);
        b.setAuthor(author);
        b.setIsbn(isbn);
        Session session = model.getSession();
        Transaction tx = session.beginTransaction();
        System.out.println("Book id: " + b.getId());
        session.persist(b);
        session.flush();
        session.getTransaction().commit();
    }

    public void addNewAuthor(String name, String nationality) {
        Author a = new Author();
        a.setName(name);
        a.setNationality(nationality);
        Session session = model.getSession();
        Transaction tx = session.beginTransaction();
        System.out.println("Author id: " + a.getId());
        session.persist(a);
        session.flush();
        session.getTransaction().commit();
    }

    public void addNewStore(String name, String address, Status status) {
        Store s = new Store();
        s.setName(name);
        s.setAddress(address);
        s.setStatus(status);
        Session session = model.getSession();
        Transaction tx = session.beginTransaction();
        System.out.println("Store id: " + s.getId());
        session.persist(s);
        session.flush();
        session.getTransaction().commit();
    }

    public List<Book> getAllBook() {
        Session session = model.getSession();
        Transaction tx = session.beginTransaction();
        List<Book> b = session.createSelectionQuery("SELECT b FROM Book b", Book.class).getResultList();

        for (Book p : b) {
            System.out.println(p);
        }
        session.clear();
        session.getTransaction().commit();
        return b;
    }

    public List<Author> getAllAuthor() {
        Session session = model.getSession();
        Transaction tx = session.beginTransaction();
        List<Author> a = session.createSelectionQuery("SELECT a FROM Author a", Author.class).getResultList();

        for (Author p : a) {
            System.out.println(p);
        }
        session.clear();
        session.getTransaction().commit();
        return a;
    }

    public List<Store> getAllStore() {
        Session session = model.getSession();
        Transaction tx = session.beginTransaction();
        List<Store> s = session.createSelectionQuery("SELECT s FROM Store s", Store.class).getResultList();

        for (Store p : s) {
            System.out.println(p);
        }
        session.clear();
        session.getTransaction().commit();
        return s;
    }

    public void deleteAuthor(Integer id) {
        Session session = model.getSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();

            Author a = session.find(Author.class, id);
            session.remove(a);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }
}
