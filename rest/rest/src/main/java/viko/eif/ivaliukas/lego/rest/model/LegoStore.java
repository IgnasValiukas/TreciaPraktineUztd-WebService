package viko.eif.ivaliukas.lego.rest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "legostores")
public class LegoStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "store_country")
    private String storeCountry;
    @Column(name = "store_city")
    private String storeCity;
    @Column(name = "store_address")
    private String storeAddress;
    @Column(name = "store_phone_number")
    private String storePhoneNumber;
    @Column(name = "address_url")
    private URL addressURL;
}
