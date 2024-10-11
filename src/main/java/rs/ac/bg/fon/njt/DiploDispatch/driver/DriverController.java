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

    @GetMapping("/getByName")
    public List<Driver> getDriversByName(@RequestParam(required = false) String name) {
        return driverService.getDriversByName(name);
    }

    @PostMapping("/add")
    public ResponseEntity<String> getAllDrivers(@RequestBody Driver driver) {
        driverService.addDriver(driver);
        return new ResponseEntity<>("Success: Driver has been added successfully.", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateTruck(@RequestBody Driver driver) {
        driverService.updateDriver(driver);
        System.out.println(driver);
        return new ResponseEntity<>("Success: Driver has been updated successfully.", HttpStatus.OK);
    }
}
