package rs.ac.bg.fon.njt.DiploDispatch.truckLoad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TruckLoadRepository extends JpaRepository<TruckLoad, Long> {
    List<TruckLoad> findByStartDate(LocalDate startDate);
}
