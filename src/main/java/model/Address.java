package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "addresses")
@Setter
@Getter
@NoArgsConstructor
public class Address implements Serializable {
    private static final Long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "city",
            nullable = false,
            length = 15)
    private String city;

    @Column(name = "ZIP_code",
            nullable = false,
            length = 6)
    private String zipCode;

    @Column(name = "street",
            nullable = false,
            length = 15)
    private String street;

    @Column(name = "house_number",
            nullable = false)
    private int houseNumber;

    @OneToOne(mappedBy = "address")
    private Owner owner;

    public Address(String city, String zipCode, String street, int houseNumber) {
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.houseNumber = houseNumber;
    }
}
