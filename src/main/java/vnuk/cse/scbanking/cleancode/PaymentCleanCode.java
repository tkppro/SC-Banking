package vnuk.cse.scbanking.cleancode;

import vnuk.cse.scbanking.entity.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class PaymentCleanCode {
    // Clean code
    
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    protected int identitydefinition;


}
