package sit.int202.preexam.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
@NamedQueries({
        @NamedQuery(name = "EMPLOYEE.COUNT", query = "select count(emp) as count from Employee emp"),
        @NamedQuery(name = "EMPLOYEE.FIND_ALL", query = "select emp from Employee emp"),
        @NamedQuery(name = "CUSTOMER.FIND_USER_BY_NAME",query = "select emp from Employee emp where concat(trim(emp.firstName), ' ', trim(emp.lastName)) = :user_account"),
        @NamedQuery(name = "CUSTOMER.FIND_USER_BY_EMAIL",query = "select emp from Employee emp where emp.email = :user_email")
})
public class Employee {
    @Id
    @Column(name = "employeeNumber", nullable = false)
    private String id;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String officeCode;
    private String reportsTo;
    private String jobTitle;
    @ManyToOne
    @JoinColumn(name = "officeCode", insertable = false,updatable = false)
    private Office office;
}
