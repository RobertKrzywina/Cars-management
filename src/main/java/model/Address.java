package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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

    @Column(name = "city")
    @NotEmpty(message = "{city.notEmpty}")
    @Size(max = 15, message = "{city.size}")
    private String city;

    @Column(name = "ZIP_code")
    @NotEmpty(message = "{zipCode.notEmpty}")
    @Size(min = 6, max = 6, message = "{zipCode.size}")
    private String zipCode;

    @Column(name = "street")
    @NotEmpty(message = "{street.notEmpty}")
    @Size(max = 15, message = "{street.size}")
    private String street;

    @Column(name = "house_number")
    private int houseNumber;

    @OneToOne(mappedBy = "address")
    private Owner owner;
}
