package rs.ac.bg.fon.njt.DiploDispatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import rs.ac.bg.fon.njt.DiploDispatch.driver.Driver;
import rs.ac.bg.fon.njt.DiploDispatch.driver.DriverRepository;
import rs.ac.bg.fon.njt.DiploDispatch.loadItem.LoadItem;
import rs.ac.bg.fon.njt.DiploDispatch.loadItem.LoadItemId;
import rs.ac.bg.fon.njt.DiploDispatch.loadItem.LoadItemRepository;
import rs.ac.bg.fon.njt.DiploDispatch.manufacturer.Manufacturer;
import rs.ac.bg.fon.njt.DiploDispatch.manufacturer.ManufacturerRepository;
import rs.ac.bg.fon.njt.DiploDispatch.role.Role;
import rs.ac.bg.fon.njt.DiploDispatch.truck.Truck;
import rs.ac.bg.fon.njt.DiploDispatch.truck.TruckRepository;
import rs.ac.bg.fon.njt.DiploDispatch.truckLoad.TruckLoad;
import rs.ac.bg.fon.njt.DiploDispatch.truckLoad.TruckLoadRepository;
import rs.ac.bg.fon.njt.DiploDispatch.user.User;
import rs.ac.bg.fon.njt.DiploDispatch.user.UserRepository;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class DiploDispatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiploDispatchApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepository userRepository,
							 PasswordEncoder passwordEncoder,
							 TruckRepository truckRepository,
							 ManufacturerRepository manufacturerRepository,
							 DriverRepository driverRepository,
							 TruckLoadRepository truckLoadRepository,
							 LoadItemRepository loadItemRepository) {
		return args -> {
			User userNew1 = User.builder()
					.firstname("Aleksa")
					.lastname("Petrovic")
					.username("Aleksa")
					.password(passwordEncoder.encode("AleksaManager123"))
					.email("aleksa.petrovic@fon.bg.ac.rs")
					.role(Role.MANAGER)
					.build();

			userRepository.save(userNew1);

			User userNew2 = User.builder()
					.firstname("Pavle")
					.lastname("Pajic")
					.username("Pavle")
					.password(passwordEncoder.encode("PavleDispatcher123"))
					.email("pavle.pajic@fon.bg.ac.rs")
					.role(Role.DISPATCHER)
					.build();

			userRepository.save(userNew2);

			Manufacturer manufacturerNew1 = Manufacturer.builder()
					.name("Scania")
					.build();

			manufacturerRepository.save(manufacturerNew1);

			Manufacturer manufacturerNew2 = Manufacturer.builder()
					.name("Volvo")
					.build();

			manufacturerRepository.save(manufacturerNew2);

			Manufacturer manufacturerNew3 = Manufacturer.builder()
					.name("Peterbilt")
					.build();

			manufacturerRepository.save(manufacturerNew3);

			Manufacturer manufacturerNew4 = Manufacturer.builder()
					.name("Freightliner")
					.build();

			manufacturerRepository.save(manufacturerNew4);

			Manufacturer manufacturerNew5 = Manufacturer.builder()
					.name("Kenworth")
					.build();

			manufacturerRepository.save(manufacturerNew5);

			Manufacturer manufacturerNew6 = Manufacturer.builder()
					.name("Mack")
					.build();

			manufacturerRepository.save(manufacturerNew6);

			Truck truckNew1 = Truck.builder()
					.model("Citywide LF")
					.power(550)
					.kilometersTravelled(421320)
					.year(2008)
					.carryingCapacity(80.5)
					.manufacturer(manufacturerNew1)
					.build();

			truckRepository.save(truckNew1);

			Driver driverNew1 = Driver.builder()
					.name("Marko")
					.surname("Petrovic")
					.birthdate(LocalDate.of(1995, 10, 21))
					.truck(truckNew1)
					.build();

			driverRepository.save(driverNew1);

			TruckLoad truckLoadNew1 = TruckLoad.builder()
					.startDate(LocalDate.of(2024, 11, 21))
					.startTime(LocalTime.of(15, 30))
					.endDate(LocalDate.of(2024, 11, 24))
					.endTime(LocalTime.of(9, 30))
					.incomePerKilometer(2.52)
					.driver(driverNew1)
					.build();

			truckLoadRepository.save(truckLoadNew1);

			LoadItemId loadItemId1 = LoadItemId.builder()
					.id(1L)
					.build();

			LoadItem item1 = LoadItem.builder()
					.id(loadItemId1)
					.name("Chair")
					.dangerous(false)
					.fragile(true)
					.weight(2.54)
					.volume(0.23)
					.truckLoad(truckLoadNew1)
					.build();

			loadItemRepository.save(item1);

			LoadItemId loadItemId2 = LoadItemId.builder()
					.id(2L)
					.build();

			LoadItem item2 = LoadItem.builder()
					.id(loadItemId2)
					.name("Table")
					.dangerous(false)
					.fragile(true)
					.weight(3.32)
					.volume(1.03)
					.truckLoad(truckLoadNew1)
					.build();

			loadItemRepository.save(item2);
		};
	}
}
