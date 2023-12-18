package sit.int202.classicmodels.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString@Entity
@Table(name = "employees")
@NamedQueries(
        @NamedQuery(name = "EMPLOYEE.FIND_ALL", query = "select emp from Employee emp")
)
public class Employee {
    @Id
    @Column(name = "employeeNumber", nullable = false)
    private Integer id;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String officeCode;
    private Integer reportsTo;
    private String jobTitle;
    private String password;
    @ManyToOne
    @JoinColumn(name = "officeCode", insertable = false,updatable = false)
    private Office office;
}
