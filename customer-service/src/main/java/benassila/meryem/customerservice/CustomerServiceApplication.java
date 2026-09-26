package benassila.meryem.customerservice;

import benassila.meryem.customerservice.entities.Customer;
import benassila.meryem.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);

        };
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args ->{
           String[] names = {"Mohamed" , "Ali", "Ilhame"};
           for (String name : names){
               Customer customer = new Customer();
               customer.setName(name);
               customer.setEmail(name+"@gmail.com");
               customerRepository.save(customer);
           }

        };
    }

}
