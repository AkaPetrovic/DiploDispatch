package rs.ac.bg.fon.njt.DiploDispatch.dto;

import lombok.Data;
import rs.ac.bg.fon.njt.DiploDispatch.loadItem.LoadItem;
import rs.ac.bg.fon.njt.DiploDispatch.truckLoad.TruckLoad;

import java.util.List;

@Data
public class AddTruckLoadRequestDTO {
    private TruckLoad truckLoad;
    private List<LoadItem> loadItems;
}
