package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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

    @Column(name = "first_name")
    @NotEmpty(message = "{firstName.notEmpty}")
    @Size(max = 15, message = "{firstName.size}")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "{lastName.notEmpty}")
    @Size(max = 15, message = "{lastName.size}")
    private String lastName;

    @Column(name = "phone_number")
    @NotEmpty(message = "{phoneNumber.notEmpty}")
    @Size(min = 9, max = 9, message = "{phoneNumber.size}")
    private String phoneNumber;

    @OneToOne
    private Car car;

    @OneToOne
    @JoinColumn(name = "id_address",
            nullable = false)
    private Address address;
}
