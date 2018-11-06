package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "owners")
@Setter
@Getter
@NoArgsConstructor
public class Owner implements Serializable {
    private static final Long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private Long id;

    @Column(name = "first_name",
            nullable = false,
            length = 15)
    private String firstName;

    @Column(name = "last_name",
            nullable = false,
            length = 15)
    private String lastName;

    @Column(name = "phone_number",
            nullable = false,
            length = 9)
    private String phoneNumber;

    @OneToOne
    private Car car;

    @OneToOne
    @JoinColumn(name = "id_address",
            nullable = false)
    private Address address;

    public Owner(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Owner(String firstName, String lastName, String phoneNumber, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
