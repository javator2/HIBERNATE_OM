package com.sda.hibernate;

import com.sda.hibernate.entity.Book;
import com.sda.hibernate.entity.Category;
import com.sda.hibernate.entity.Publisher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);

        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {

        Book book = new Book();
        book.setAuthor("Jan");
        book.setIsbn("324-234");
        book.setTitle("Nowe");

        Book book1 = new Book("Kolejne", "2", "Mirek");

        Session session = getSession();
        Transaction tx = session.getTransaction();

        tx.begin();
        session.save(book);
        session.save(book1);
        tx.commit();

        tx.begin();
        Book book2 = new Book("Nastepne", "3", "Kazik");
        session.save(book2);
        tx.commit();

        tx.begin();
        Category category = new Category("Adamowski ");
        session.save(category);
        Category category1 = new Category("Jeszcze kto inny");
        session.save(category1);
        tx.commit();

/*
        List<Book> bookList = session.createQuery("from " + Book.class.getName()).list();
        for (Book b : bookList){
            b = (Book) session.createQuery("delete from book where " + b.getTitle() + " = 'Nowe'").uniqueResult();
            System.out.println(b.getAuthor() + " " + b.getTitle());
        }

*/

/*        Book book3 = session.byId(Book.class).getReference(1);            // usuwanie ksiazki
        System.out.println(book3);

        tx.begin();
        session.delete(book3);
        tx.commit();

        session.close();*/
        Publisher publisher = new Publisher("PWN", "Mickiewicza", "Torun");
        Category category2 = new Category("Fantastyka67");
        Book book3 = new Book();
        book3.setTitle("Jeszcze jedna");
        book3.setIsbn("3245-54353-432");
        book3.setAuthor("Antek");
        book3.setCategory(category2);
        book3.setPublisher(publisher);

        tx.begin();
        session.save(book3);
        tx.commit();
        session.close();
    }
}