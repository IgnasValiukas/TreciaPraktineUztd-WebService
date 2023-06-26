package viko.eif.ivaliukas.lego.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import viko.eif.ivaliukas.lego.rest.model.Employee;
import viko.eif.ivaliukas.lego.rest.model.Lego;
import viko.eif.ivaliukas.lego.rest.model.LegoStore;
import viko.eif.ivaliukas.lego.rest.repository.EmployeeRepository;
import viko.eif.ivaliukas.lego.rest.repository.LegoRepository;
import viko.eif.ivaliukas.lego.rest.repository.LegoStoreRepository;

@SpringBootApplication
public class RestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private LegoRepository legoRepository;
	@Autowired
	private LegoStoreRepository legoStoreRepository;

	@Override
	public void run(String... args) throws Exception {
		/*LegoStore st1 = new LegoStore();
		st1.setStoreCountry("Lithuania");
		st1.setStoreCity("Vilnius");
		st1.setStoreName("Lego Store");
		st1.setStorePhoneNumber("+370 600 00000");
		legoStoreRepository.save(st1);*/
	}
}
