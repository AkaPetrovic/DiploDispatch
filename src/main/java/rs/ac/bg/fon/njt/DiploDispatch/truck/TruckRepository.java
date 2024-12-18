package rs.ac.bg.fon.njt.DiploDispatch.truck;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Long> {
    List<Truck> findByManufacturer_Id(Long manufacturer_id);
}
