package rs.ac.bg.fon.njt.DiploDispatch.truck;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.njt.DiploDispatch.manufacturer.Manufacturer;

import java.util.List;

@RestController
@RequestMapping("/api/trucks")
@RequiredArgsConstructor
public class TruckController {
    private final TruckService truckService;

    @GetMapping("/getByManufacturer")
    public List<Truck> getTrucksByManufacturer(@RequestBody Manufacturer manufacturer) {
        return truckService.getTrucksByManufacturer(manufacturer);
    }
}
