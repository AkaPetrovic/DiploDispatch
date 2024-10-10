package rs.ac.bg.fon.njt.DiploDispatch.driver;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import rs.ac.bg.fon.njt.DiploDispatch.truck.Truck;
import rs.ac.bg.fon.njt.DiploDispatch.truckLoad.TruckLoad;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "driver")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @ManyToOne
    @JoinColumn(name = "truck_id",
                nullable = false,
                foreignKey = @ForeignKey(name = "FK_driver_truck"))
    private Truck truck;

    @OneToMany(mappedBy = "driver", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<TruckLoad> truckLoads;
}
