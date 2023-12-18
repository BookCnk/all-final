package sit.int202.preexam.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderdetails")
@NamedQueries({
        @NamedQuery(name = "ORDER_DETAIL.FIND_ALL", query = "select odt from Orderdetail odt")
})
public class Orderdetail {
    @Id
    private String orderNumber;
    private String productCode;
    private String quantityOrdered;
    private String priceEach;
    private String orderLineNumber;
}
