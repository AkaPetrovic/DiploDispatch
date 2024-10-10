package rs.ac.bg.fon.njt.DiploDispatch.driver;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @GetMapping()
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @PostMapping("/add")
    public ResponseEntity<String> getAllDrivers(@RequestBody Driver driver) {
        driverService.addDriver(driver);
        return new ResponseEntity<>("Success: Driver has been added successfully.", HttpStatus.CREATED);
    }
}
