package model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "cars")
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @NotEmpty(message = "{brand.notEmpty}")
    @Column(nullable = false)
    private String brand;

    @NonNull
    @NotEmpty(message = "{model.notEmpty}")
    @Column(nullable = false)
    private String model;

    @NonNull
    @NotEmpty(message = "{engine.notEmpty}")
    @Column(nullable = false)
    private String engine;

    private int year;

    private double price;

    @OneToOne
    @JoinColumn(name = "id_owner",
                nullable = false)
    private Owner owner;

    public Car(String brand, String model, String engine, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.year = year;
        this.price = price;
    }
}
