package rs.ac.bg.fon.njt.DiploDispatch.truckLoad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckLoadRepository extends JpaRepository<TruckLoad, Long> {
}
