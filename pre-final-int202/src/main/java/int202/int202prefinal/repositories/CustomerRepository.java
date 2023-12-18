package int202.int202prefinal.repositories;

import int202.int202prefinal.entities.Customer;
import int202.int202prefinal.utilities.EntityManagerBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class CustomerRepository {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public boolean insert(Customer customer) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }


    public Customer findByUserName(String accountName) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("CUSTOMER.FIND_USERNAME");
        query.setParameter("userName", accountName);
        Customer customer = null;
        try {
            customer = (Customer) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("No result");
        }
        return customer;
    }

    public Customer findByCustomerName(String accountName) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("CUSTOMER.FIND_NAME");
        query.setParameter("user_account", accountName);
        Customer customer = null;
        try {
            customer = (Customer) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("No result");
        }
        return customer;
    }



    public List<Customer> findAll() {
        return getEntityManager().createNamedQuery("CUSTOMER.FIND_ALL").getResultList();
    }
}
