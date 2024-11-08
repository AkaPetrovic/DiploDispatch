package rs.ac.bg.fon.njt.DiploDispatch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rs.ac.bg.fon.njt.DiploDispatch.driver.Driver;
import rs.ac.bg.fon.njt.DiploDispatch.driver.DriverRepository;
import rs.ac.bg.fon.njt.DiploDispatch.manufacturer.Manufacturer;
import rs.ac.bg.fon.njt.DiploDispatch.manufacturer.ManufacturerRepository;
import rs.ac.bg.fon.njt.DiploDispatch.truck.Truck;
import rs.ac.bg.fon.njt.DiploDispatch.truck.TruckRepository;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DriverRepositoryTests {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private TruckRepository truckRepository;

    @Test
    public void testFindByName() {
        Manufacturer manufacturer = Manufacturer.builder()
                .name("Manufacturer 1")
                .build();
        manufacturerRepository.save(manufacturer);

        Truck truck = Truck.builder()
                .model("Model 1")
                .power(123)
                .kilometersTravelled(123123)
                .year(2015)
                .carryingCapacity(20.52)
                .manufacturer(manufacturer)
                .build();
        truckRepository.save(truck);

        Driver driver = Driver.builder()
                .name("John")
                .surname("Smith")
                .birthdate(LocalDate.of(1990, 10, 21))
                .truck(truck)
                .build();
        driverRepository.save(driver);

        List<Driver> foundDrivers = driverRepository.findByName("John");

        assertEquals(1, foundDrivers.size());
        assertEquals("John", foundDrivers.get(0).getName());

        driverRepository.delete(driver);
        truckRepository.delete(truck);
        manufacturerRepository.delete(manufacturer);

    }
}
