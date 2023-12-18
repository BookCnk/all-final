package int202.int202prefinal.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "employees")
@NamedQueries({
        @NamedQuery(name = "EMPLOYEE.FIND_ALL", query = "select e from Employee e"),
        @NamedQuery(name = "EMPLOYEE.FIND_USERNAME", query = "select e from Employee e where concat(trim(e.firstName), ' ', trim(e.lastName)) = :userName"),
        @NamedQuery(name = "EMPLOYEE.FIND_NAME", query = "select e from Employee e where concat(trim(e.firstName), ' ', trim(e.lastName)) = :userName")
})

public class Employee {
    @Id
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String officeCode;
    private Integer reportsTo;
    private String jobTitle;
    private String password;
    @ManyToOne
    @JoinColumn(name = "officeCode", insertable = false, updatable = false)
    private Office office;
}
