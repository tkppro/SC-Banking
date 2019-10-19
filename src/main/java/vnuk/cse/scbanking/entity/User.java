package vnuk.cse.scbanking.entity;

import lombok.Data;

import vnuk.cse.scbanking.entity.Payment;
import vnuk.cse.scbanking.entity.Card;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="users")
public class User implements Serializable {

    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "f_name")
    private String firstName;

    @Column(name = "l_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "address")
    private String address;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @OneToMany(mappedBy = "user")
    private List<Card> card;

    @OneToMany(mappedBy = "user")
    private List<Payment> payment;

    public String getEmail() {
        return this.email;
    }
}