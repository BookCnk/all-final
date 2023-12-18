package sit.int202.preexam.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payments")
@NamedQueries({
        @NamedQuery(name = "PAYMENT.FIND_ALL", query = "select pm from Payment pm")
})
public class Payment {
    @Id
    private String customerNumber;
    private String checkNumber;
    private String paymentDate;
    private String amount;
}
