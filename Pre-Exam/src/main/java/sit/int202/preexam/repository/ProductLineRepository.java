package sit.int202.preexam.repository;

import jakarta.persistence.EntityManager;
import sit.int202.preexam.entities.Customer;

import java.util.List;

public class ProductLineRepository {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }
    public List<Customer> findAll() {
        return getEntityManager().createNamedQuery("PRODUCT_LINE.FIND_ALL").getResultList();
    }
    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
