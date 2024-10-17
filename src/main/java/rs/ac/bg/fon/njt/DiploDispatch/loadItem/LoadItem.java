package rs.ac.bg.fon.njt.DiploDispatch.loadItem;

import jakarta.persistence.*;
import lombok.*;
import rs.ac.bg.fon.njt.DiploDispatch.truckLoad.TruckLoad;

@Entity
@Table(name = "load_item")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class LoadItem {
    @EmbeddedId
    private LoadItemId id;

    @ManyToOne
    @MapsId("truckLoadId")
    @JoinColumn(name = "truck_load_id",
                nullable = false,
                foreignKey = @ForeignKey(name = "FK_truck_load"))
    @ToString.Exclude
    private TruckLoad truckLoad;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "dangerous", nullable = false)
    private Boolean dangerous;

    @Column(name = "fragile", nullable = false)
    private Boolean fragile;

    @Column(name = "weight", nullable = false)
    private Double weight;

    @Column(name = "volume", nullable = false)
    private Double volume;
}
