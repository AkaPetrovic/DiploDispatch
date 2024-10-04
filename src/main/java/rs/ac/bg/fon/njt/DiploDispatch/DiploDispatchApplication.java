package rs.ac.bg.fon.njt.DiploDispatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import rs.ac.bg.fon.njt.DiploDispatch.manufacturer.Manufacturer;
import rs.ac.bg.fon.njt.DiploDispatch.manufacturer.ManufacturerRepository;
import rs.ac.bg.fon.njt.DiploDispatch.role.Role;
import rs.ac.bg.fon.njt.DiploDispatch.truck.Truck;
import rs.ac.bg.fon.njt.DiploDispatch.truck.TruckRepository;
import rs.ac.bg.fon.njt.DiploDispatch.user.User;
import rs.ac.bg.fon.njt.DiploDispatch.user.UserRepository;

@SpringBootApplication
public class DiploDispatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiploDispatchApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepository userRepository,
							 PasswordEncoder passwordEncoder,
							 TruckRepository truckRepository,
							 ManufacturerRepository manufacturerRepository) {
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

			Truck truckNew1 = Truck.builder()
					.model("Citywide LF")
					.power(550)
					.kilometersTravelled(421320)
					.year(2008)
					.carryingCapacity(80.5)
					.manufacturer(manufacturerNew1)
					.build();

			truckRepository.save(truckNew1);
		};
	}
}
