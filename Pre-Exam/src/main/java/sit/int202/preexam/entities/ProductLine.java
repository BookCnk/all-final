package sit.int202.preexam.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productlines")
@NamedQueries({
        @NamedQuery(name = "PRODUCT_LINE.FIND_ALL", query = "select pdl from ProductLine pdl")
})
public class ProductLine {
    @Id
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private String image;
}
