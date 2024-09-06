package rs.ac.bg.fon.njt.DiploDispatch.truckLoad;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TruckLoadService {
    private final TruckLoadRepository truckLoadRepository;
}
