package rs.ac.bg.fon.njt.DiploDispatch.truckLoad;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.njt.DiploDispatch.dto.TruckLoadWithLoadItemsRequestDTO;
import rs.ac.bg.fon.njt.DiploDispatch.loadItem.LoadItem;

import java.util.List;

@RestController
@RequestMapping("/api/loads")
@RequiredArgsConstructor
public class TruckLoadController {
    private final TruckLoadService truckLoadService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('MANAGER', 'DISPATCHER')")
    public List<TruckLoad> getAllTruckLoads() {
        return truckLoadService.getAllTruckLoads();
    }

    @GetMapping("/getByStartDate")
    @PreAuthorize("hasAnyAuthority('MANAGER', 'DISPATCHER')")
    public List<TruckLoad> getTruckLoadsByStartDate(@RequestParam(required = false) String date) {
        return truckLoadService.getTruckLoadsByStartDate(date);
    }

    @GetMapping("/{id}/items")
    @PreAuthorize("hasAnyAuthority('MANAGER', 'DISPATCHER')")
    public List<LoadItem> getLoadItems(@PathVariable Long id) {
        return truckLoadService.getLoadItems(id);
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('DISPATCHER')")
    public ResponseEntity<String> addTruckLoad(@RequestBody TruckLoadWithLoadItemsRequestDTO truckLoadWithLoadItemsRequestDTO) {
        truckLoadService.addTruckLoad(truckLoadWithLoadItemsRequestDTO);
        return new ResponseEntity<>("Success: Truck load has been added successfully.", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAnyAuthority('DISPATCHER')")
    public ResponseEntity<String> updateTruckLoad(@RequestBody TruckLoadWithLoadItemsRequestDTO truckLoadWithLoadItemsRequestDTO) {
        truckLoadService.updateTruckLoad(truckLoadWithLoadItemsRequestDTO);
        return new ResponseEntity<>("Success: Truck load has been updated successfully.", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAnyAuthority('DISPATCHER')")
    public ResponseEntity<String> deleteTruckLoad(@RequestBody TruckLoadWithLoadItemsRequestDTO truckLoadWithLoadItemsRequestDTO) {
        truckLoadService.deleteTruckLoad(truckLoadWithLoadItemsRequestDTO);
        return new ResponseEntity<>("Success: Truck load has been deleted successfully.", HttpStatus.OK);
    }
}
