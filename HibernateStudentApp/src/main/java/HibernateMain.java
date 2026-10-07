import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMain {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            Student student = new Student(
            		"Vijayalakshmi",
                    "vijayalakshmi@gmail.com",
                    "AI&DS"
            );

            session.persist(student);

            session.getTransaction().commit();

            System.out.println("Student saved successfully!");

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
            factory.close();
        }
    }
}
