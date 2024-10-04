package rs.ac.bg.fon.njt.DiploDispatch.truck;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.njt.DiploDispatch.manufacturer.Manufacturer;

import java.util.List;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Long> {
    List<Truck> findByManufacturer(Manufacturer manufacturer);
}
