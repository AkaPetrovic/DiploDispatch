package rs.ac.bg.fon.njt.DiploDispatch.truckLoad;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.njt.DiploDispatch.dto.AddTruckLoadRequestDTO;
import rs.ac.bg.fon.njt.DiploDispatch.loadItem.LoadItem;
import rs.ac.bg.fon.njt.DiploDispatch.loadItem.LoadItemId;
import rs.ac.bg.fon.njt.DiploDispatch.loadItem.LoadItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TruckLoadService {
    private final TruckLoadRepository truckLoadRepository;
    private final LoadItemRepository loadItemRepository;

    public List<TruckLoad> getAllTruckLoads() {
        return truckLoadRepository.findAll();
    }

    public void addTruckLoad(AddTruckLoadRequestDTO addTruckLoadRequestDTO) {
        TruckLoad truckLoad = addTruckLoadRequestDTO.getTruckLoad();
        List<LoadItem> loadItems = addTruckLoadRequestDTO.getLoadItems();
        truckLoadRepository.save(truckLoad);

        System.out.println(truckLoad);
        System.out.println(loadItems);

        Long id = 1L;
        for(LoadItem loadItem : loadItems) {
            loadItem.setTruckLoad(truckLoad);
            loadItem.setId(new LoadItemId(truckLoad.getId(), id++));
            loadItemRepository.save(loadItem);
        }
    }
}
