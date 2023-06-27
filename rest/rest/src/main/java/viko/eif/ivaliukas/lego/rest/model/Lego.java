package viko.eif.ivaliukas.lego.rest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "legos")
public class Lego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "lego_number")
    private int legoNumber;
    @Column(name = "piece_count")
    private int pieceCount;
    @Column(name = "price")
    private double price;
    @Column(name = "age")
    private String age;

    @OneToMany(cascade = CascadeType.ALL)
    private List<LegoStore> legoStore;
}
