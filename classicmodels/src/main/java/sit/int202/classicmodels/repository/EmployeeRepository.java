package sit.int202.classicmodels.repository;

import jakarta.persistence.EntityManager;
import sit.int202.classicmodels.entities.Employee;

import java.util.List;

public class EmployeeRepository {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public List<Employee> findAll() {
        return getEntityManager().createQuery("SELECT e from Employee e").getResultList();
    }
}
