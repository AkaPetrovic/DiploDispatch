package rs.ac.bg.fon.njt.DiploDispatch.driver;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public void addDriver(Driver driver) {
        driverRepository.save(driver);
    }

    public List<Driver> getDriversByName(String name) {
        if (name != null && !name.isEmpty()) {
            List<Driver> driversByName = driverRepository.findByName(name);
            if(driversByName.isEmpty()){
                throw new NoSuchElementException("Error: No drivers have been found for the given name.");
            }
            return driversByName;
        } else {
            throw new IllegalArgumentException("Error: Driver name cannot be empty.");
        }
    }

    public void updateDriver(Driver driver) {
        driverRepository.save(driver);
    }

    public void deleteDriver(Driver driver) {
        driverRepository.delete(driver);
    }
}
