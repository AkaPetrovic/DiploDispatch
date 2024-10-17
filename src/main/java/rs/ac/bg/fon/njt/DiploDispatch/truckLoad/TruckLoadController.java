package rs.ac.bg.fon.njt.DiploDispatch.truckLoad;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.njt.DiploDispatch.dto.AddTruckLoadRequestDTO;

import java.util.List;

@RestController
@RequestMapping("/api/loads")
@RequiredArgsConstructor
public class TruckLoadController {
    private final TruckLoadService truckLoadService;

    @GetMapping
    public List<TruckLoad> getAllTruckLoads() {
        return truckLoadService.getAllTruckLoads();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addTruckLoad(@RequestBody AddTruckLoadRequestDTO addTruckLoadRequestDTO) {
        truckLoadService.addTruckLoad(addTruckLoadRequestDTO);
        return new ResponseEntity<>("Success: Truck load has been added successfully.", HttpStatus.CREATED);
    }
}
