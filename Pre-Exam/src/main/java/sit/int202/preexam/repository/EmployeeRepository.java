package sit.int202.preexam.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.preexam.entities.Employee;

import java.util.List;

public class EmployeeRepository {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }
    private static int PAGE_SIZE = 5;

    public int getDefaultPageSize() {
        return PAGE_SIZE;
    }
    public List<Employee> findAll() {
        return getEntityManager().createNamedQuery("EMPLOYEE.FIND_ALL").getResultList();
    }
    public List<Employee> findAllByPage(int page, int pageSize) {
        int startPosition = (page - 1) * pageSize;
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNamedQuery("EMPLOYEE.FIND_ALL");
        query.setFirstResult(startPosition);
        query.setMaxResults(pageSize);
        List<Employee> productList = query.getResultList();
        entityManager.close();
        return productList;
    }
    public int countAll() {
        EntityManager entityManager = getEntityManager();
        int number = ((Number) entityManager.createNamedQuery("EMPLOYEE.COUNT").getSingleResult()).intValue();
        entityManager.close();
        return number;
    }
    public Employee find(String employeeNumber) {
        return getEntityManager().find(Employee.class, employeeNumber);
    }

    public Employee findByName(String name) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("CUSTOMER.FIND_USER_BY_NAME");
        query.setParameter("user_account", name);
        try {
            return (Employee) query.getSingleResult();
        }catch (Exception e){
            return null;
        }
    }
    public Employee findByEmail(String email) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("CUSTOMER.FIND_USER_BY_EMAIL");
        query.setParameter("user_email", email);
        try {
            return (Employee) query.getSingleResult();
        }catch (Exception e){
            return null;
        }
    }

    public boolean insert(Employee employeeNumber) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(employeeNumber);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean delete(String employeeNumber) {
        EntityManager entityManager = getEntityManager();
        Employee employee = find(employeeNumber);
        try {
            if (employee != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(employee);
                entityManager.getTransaction().commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public boolean update(Employee newEmployee) {
        if (newEmployee != null) {
            EntityManager entityManager = getEntityManager();
            Employee employee = find(newEmployee.getId());
            if (employee != null) {
                entityManager.getTransaction().begin();
                employee.setLastName(newEmployee.getLastName());
                employee.setFirstName(newEmployee.getFirstName());
                employee.setExtension(newEmployee.getExtension());
                employee.setEmail(newEmployee.getEmail());
                employee.setOfficeCode(newEmployee.getOfficeCode());
                employee.setReportsTo(newEmployee.getReportsTo());
                employee.setJobTitle(newEmployee.getJobTitle());
                entityManager.getTransaction().commit();
                return true;
            }
        }
        return false;
    }
    public String getNewId(){
        Query query = getEntityManager().createNamedQuery("EMPLOYEE.FIND_ALL");
        List<Employee> employeeList = query.getResultList();
        int max = 0;
        for (Employee employee : employeeList) {
            int officeCode = Integer.parseInt(employee.getId());
            if (officeCode > max) {
                max = officeCode;
            }
        }
        return String.valueOf(max + 1);
    }
    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
