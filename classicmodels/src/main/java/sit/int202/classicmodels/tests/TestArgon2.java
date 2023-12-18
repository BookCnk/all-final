package sit.int202.classicmodels.tests;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import sit.int202.classicmodels.entities.Customer;
import sit.int202.classicmodels.entities.Employee;
import sit.int202.classicmodels.repository.EmployeeRepository;
import sit.int202.classicmodels.repository.CustomerRepository;

import java.util.Scanner;

public class TestArgon2 {
    // add data to colum password
    private static void initPassword(Argon2 argon2) {
        EmployeeRepository repository = new EmployeeRepository();
        repository.getEntityManager().getTransaction().begin();
        char[] password;
        for (Employee e : repository.findAll()) {
            password = e.getId().toString().toCharArray();
            e.setPassword(argon2.hash(2, 16, 1, password));
        }
        repository.getEntityManager().getTransaction().commit();
    }

    public static void main(String[] args) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d, 16, 16);
        initPassword(argon2);

    }



}
