package rs.ac.bg.fon.njt.DiploDispatch.driver;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
