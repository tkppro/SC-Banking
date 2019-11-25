package vnuk.cse.scbanking.entity;

import lombok.Data;
import vnuk.cse.scbanking.entity.Payment;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="bills")
public class Bill implements Serializable {
    public Bill(String name, Date createdAt) {
        this.name = name;
        this.createdAt = createdAt;
    }

    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @OneToMany(mappedBy = "bill")
    private List<Payment> payment;

    public String getName() {
        return this.name;
    }
}