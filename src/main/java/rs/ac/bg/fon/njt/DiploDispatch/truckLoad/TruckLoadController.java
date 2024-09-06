package rs.ac.bg.fon.njt.DiploDispatch.truckLoad;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loads")
@RequiredArgsConstructor
public class TruckLoadController {
    private final TruckLoadService truckLoadService;
}
