package rs.ac.bg.fon.njt.DiploDispatch.truck;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TruckService {
    private final TruckRepository truckRepository;
}
