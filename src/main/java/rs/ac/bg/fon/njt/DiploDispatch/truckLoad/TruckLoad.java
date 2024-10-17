package rs.ac.bg.fon.njt.DiploDispatch.truckLoad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import rs.ac.bg.fon.njt.DiploDispatch.driver.Driver;
import rs.ac.bg.fon.njt.DiploDispatch.loadItem.LoadItem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "truck_load")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class TruckLoad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @Column(name = "income_per_kilometer", nullable = false)
    private Double incomePerKilometer;

    @ManyToOne
    @JoinColumn(name = "driver_id",
                nullable = false,
                foreignKey = @ForeignKey(name = "FK_truck_load_driver"))
    private Driver driver;

    @OneToMany(mappedBy = "truckLoad", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @ToString.Exclude
    @JsonIgnore
    private List<LoadItem> loadItems = new ArrayList<>();
}
