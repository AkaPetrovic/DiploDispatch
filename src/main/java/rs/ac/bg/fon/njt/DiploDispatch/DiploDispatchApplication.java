package rs.ac.bg.fon.njt.DiploDispatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import rs.ac.bg.fon.njt.DiploDispatch.role.Role;
import rs.ac.bg.fon.njt.DiploDispatch.user.User;
import rs.ac.bg.fon.njt.DiploDispatch.user.UserRepository;

@SpringBootApplication
public class DiploDispatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiploDispatchApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepository userRepository,
							 PasswordEncoder passwordEncoder) {
		return args -> {
			User user = User.builder()
					.firstname("Aleksa")
					.lastname("Petrovic")
					.username("Aleksa")
					.password(passwordEncoder.encode("AkaDiplo123"))
					.email("aleksa.petrovic@fon.bg.ac.rs")
					.role(Role.MANAGER)
					.build();

			userRepository.save(user);
		};
	}
}
