package int202.int202prefinal.repositories;

import int202.int202prefinal.entities.Customer;
import int202.int202prefinal.entities.Employee;
import int202.int202prefinal.entities.Office;
import int202.int202prefinal.utilities.EntityManagerBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
public class EmployeeRepository {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public Employee findByUserName(String accountName) { // FIND USERNAME
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("EMPLOYEE.FIND_USERNAME");
        query.setParameter("userName", accountName);
        Employee employee = null;
        try {
            employee = (Employee) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("No result");
        }
        return employee;
    }





    public List<Office> findAll() {
        return getEntityManager().createNamedQuery("EMPLOYEE.FIND_ALL").getResultList();
    }
}
