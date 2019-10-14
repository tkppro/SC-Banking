package vnuk.cse.scbanking.entity;
import lombok.Data;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="cards")
public class Card implements Serializable{
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "card_number")
    private String card_number;

    @Column(name = "cvv")
    private int cvv;

    @Column(name = "expired_date")
    private String expiredDate;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private int userId;
}