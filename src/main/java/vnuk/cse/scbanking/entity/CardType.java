package vnuk.cse.scbanking.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="card_type")
public class CardType {
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @OneToOne(mappedBy = "cardType")
    private Card card;
}
