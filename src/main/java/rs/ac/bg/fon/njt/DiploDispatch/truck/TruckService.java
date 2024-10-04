package rs.ac.bg.fon.njt.DiploDispatch.truck;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.njt.DiploDispatch.manufacturer.Manufacturer;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TruckService {
    private final TruckRepository truckRepository;

    public List<Truck> getTrucksByManufacturer(Manufacturer manufacturer) {
        return truckRepository.findByManufacturer(manufacturer);
    }
}
