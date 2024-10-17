package rs.ac.bg.fon.njt.DiploDispatch.loadItem;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class LoadItemId {
    private Long truckLoadId;
    private Long id;
}
