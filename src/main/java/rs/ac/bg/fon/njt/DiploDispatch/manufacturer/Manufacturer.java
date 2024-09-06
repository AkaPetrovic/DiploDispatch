package rs.ac.bg.fon.njt.DiploDispatch.manufacturer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import rs.ac.bg.fon.njt.DiploDispatch.truck.Truck;

import java.util.List;

@Entity
@Table(name = "manufacturer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Truck> trucks;
}
