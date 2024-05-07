package lydialogic.rentacar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}

	@Bean //IoC de olmayan nesneler icin bu etiket kontrol edilir. ve container icine asagidaki kod eklenir. basina @Service yazilanlari ioc uretir ancak olmayanlari da bizim manuel eklememiz gerekir. bunun icin de @Bean ile ekleriz.
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
