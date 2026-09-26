package benassila.meryem.builing_service.entities;

import benassila.meryem.builing_service.model.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bill {
    @Id @GeneratedValue
    private Long id ;
    private Date billingDate;
    private long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems ;
    @Transient //Cet attribut Java ne doit PAS être enregistré dans la base de données.
    private Customer customer;

}
