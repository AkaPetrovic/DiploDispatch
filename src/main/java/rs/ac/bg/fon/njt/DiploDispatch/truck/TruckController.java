package rs.ac.bg.fon.njt.DiploDispatch.truck;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trucks")
@RequiredArgsConstructor
public class TruckController {
    private final TruckService truckService;

    @GetMapping()
    public List<Truck> getAllTrucks() {
        return truckService.getAllTrucks();
    }

    @GetMapping("/manufacturer/{id}")
    public List<Truck> getTrucksByManufacturer(@PathVariable Long id) {
        return truckService.getTrucksByManufacturerId(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addTruck(@RequestBody Truck truck) {
        truckService.addTruck(truck);
        return new ResponseEntity<>("Success: Truck has been added successfully.", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateTruck(@RequestBody Truck truck) {
        truckService.updateTruck(truck);
        return new ResponseEntity<>("Success: Truck has been updated successfully.", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTruck(@RequestBody Truck truck) {
        truckService.deleteTruck(truck);
        return new ResponseEntity<>("Success: Truck has been deleted successfully.", HttpStatus.OK);
    }
}

