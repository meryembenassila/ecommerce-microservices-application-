package benassila.meryem.invetory_service;

import benassila.meryem.invetory_service.entities.Product;
import benassila.meryem.invetory_service.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InvetoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvetoryServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            String[] names = {"Smart Phone", "Mouse", "Pc"};
            for (String name : names) {
                Product product = new Product();
                product.setName(name);
                product.setPrice(Math.random() * 100);
                product.setQuantity((int) (Math.random() * 100) + 1);
                productRepository.save(product);
            }


        };
    }
}