package sit.int202.preexam.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.preexam.entities.Customer;

import java.util.List;

public class CustomerRepository {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }
    public List<Customer> findAll() {
        return getEntityManager().createNamedQuery("CUSTOMER.FIND_ALL").getResultList();
    }
    public Customer findByName(String name) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("CUSTOMER.FIND_USER");
        query.setParameter("user_account", name);
        try {
            return (Customer) query.getSingleResult();
        }catch (Exception e){
            return null;
        }
    }
    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
