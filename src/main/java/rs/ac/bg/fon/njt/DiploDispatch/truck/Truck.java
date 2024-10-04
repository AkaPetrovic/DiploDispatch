package rs.ac.bg.fon.njt.DiploDispatch.truck;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import rs.ac.bg.fon.njt.DiploDispatch.driver.Driver;
import rs.ac.bg.fon.njt.DiploDispatch.manufacturer.Manufacturer;

import java.util.List;

@Entity
@Table(name = "truck")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "power", nullable = false)
    private Integer power;

    @Column(name = "kilometers_travelled", nullable = false)
    private Integer kilometersTravelled;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "carrying_capacity", nullable = false)
    private Double carryingCapacity;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id",
                nullable = false,
                foreignKey = @ForeignKey(name = "FK_truck_manufacturer"))
    private Manufacturer manufacturer;

    @OneToMany(mappedBy = "truck", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Driver> drivers;
}
