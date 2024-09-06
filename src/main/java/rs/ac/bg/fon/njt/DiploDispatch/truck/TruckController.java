package rs.ac.bg.fon.njt.DiploDispatch.truck;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trucks")
@RequiredArgsConstructor
public class TruckController {
    private final TruckService truckService;
}
