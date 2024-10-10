package rs.ac.bg.fon.njt.DiploDispatch.truck;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TruckService {
    private final TruckRepository truckRepository;

    public List<Truck> getTrucksByManufacturerId(int id) {
        List<Truck> trucksByManufacturerId = truckRepository.findByManufacturer_Id(id);
        if(trucksByManufacturerId.isEmpty()) {
            throw new NoSuchElementException("Error: No trucks have been found for the given manufacturer.");
        }
        return trucksByManufacturerId;
    }

    public void addTruck(Truck truck) {
        truckRepository.save(truck);
    }

    public void updateTruck(Truck truck) {
        truckRepository.save(truck);
    }

    public void deleteTruck(Truck truck) {
        truckRepository.delete(truck);
    }

    public List<Truck> getAllTrucks() {
        return truckRepository.findAll();
    }
}
