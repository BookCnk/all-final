package sit.int202.preexam.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@NamedQueries({
        @NamedQuery(name = "ORDER.FIND_ALL", query = "select od from Order od")
})
public class Order {
    @Id
    private String orderNumber;
    private String orderDate;
    private String requiredDate;
    private String shippedDate;
    private String status;
    private String comments;
    private String customerNumber;
}
