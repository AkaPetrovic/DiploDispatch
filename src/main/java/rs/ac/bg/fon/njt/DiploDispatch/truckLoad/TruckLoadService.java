package rs.ac.bg.fon.njt.DiploDispatch.truckLoad;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.njt.DiploDispatch.dto.TruckLoadWithLoadItemsRequestDTO;
import rs.ac.bg.fon.njt.DiploDispatch.loadItem.LoadItem;
import rs.ac.bg.fon.njt.DiploDispatch.loadItem.LoadItemId;
import rs.ac.bg.fon.njt.DiploDispatch.loadItem.LoadItemRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TruckLoadService {
    private final TruckLoadRepository truckLoadRepository;
    private final LoadItemRepository loadItemRepository;

    public List<TruckLoad> getAllTruckLoads() {
        return truckLoadRepository.findAll();
    }

    public void addTruckLoad(TruckLoadWithLoadItemsRequestDTO truckLoadWithLoadItemsRequestDTO) {
        TruckLoad truckLoad = truckLoadWithLoadItemsRequestDTO.getTruckLoad();
        List<LoadItem> loadItems = truckLoadWithLoadItemsRequestDTO.getLoadItems();
        truckLoadRepository.save(truckLoad);

        Long id = 1L;
        for(LoadItem loadItem : loadItems) {
            loadItem.setTruckLoad(truckLoad);
            loadItem.setId(new LoadItemId(truckLoad.getId(), id++));
            loadItemRepository.save(loadItem);
        }
    }

    public void updateTruckLoad(TruckLoadWithLoadItemsRequestDTO truckLoadWithLoadItemsRequestDTO) {
        TruckLoad truckLoad = truckLoadWithLoadItemsRequestDTO.getTruckLoad();
        List<LoadItem> loadItems = truckLoadWithLoadItemsRequestDTO.getLoadItems();

        List<LoadItem> loadItemsWithId = new ArrayList<>();
        List<LoadItem> loadItemsWithoutId = new ArrayList<>();

        for(LoadItem loadItem : loadItems) {
            if(loadItem.getId() == null) {
                loadItemsWithoutId.add(loadItem);
            } else {
                loadItemsWithId.add(loadItem);
            }
        }

        Long maxId = -1L;
        for(LoadItem loadItem : loadItemsWithId) {
            if(loadItem.getId().getId() > maxId){
                maxId = loadItem.getId().getId();
            }
        }

        for(LoadItem loadItem : loadItemsWithoutId) {
            loadItem.setTruckLoad(truckLoad);
            loadItem.setId(new LoadItemId(truckLoad.getId(), ++maxId));
            loadItemsWithId.add(loadItem);
        }

        truckLoad.setLoadItems(loadItemsWithId);
        truckLoadRepository.save(truckLoad);
    }

    public List<TruckLoad> getTruckLoadsByStartDate(String date) {
        if (date != null && !date.isEmpty()) {
            String[] dateSplit = date.split("-");
            LocalDate startDate = LocalDate.of(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));
            List<TruckLoad> truckLoadsByStartDate = truckLoadRepository.findByStartDate(startDate);
            if(truckLoadsByStartDate.isEmpty()){
                throw new NoSuchElementException("Error: No truck loads have been found for the given departure date.");
            }
            return truckLoadsByStartDate;
        } else {
            throw new IllegalArgumentException("Error: Departure date is not entered correctly or is empty.");
        }
    }

    public List<LoadItem> getLoadItems(Long id) {
        return loadItemRepository.findByTruckLoad_Id(id);
    }
}
