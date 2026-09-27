package benassila.meryem.builing_service;

import benassila.meryem.builing_service.entities.Bill;
import benassila.meryem.builing_service.entities.ProductItem;
import benassila.meryem.builing_service.repositories.BillRepository;
import benassila.meryem.builing_service.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients //POUR acctiver openfeign //pour que openfeign créer une imlemntation des interfaces qu'on a crée
public class BuilingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuilingServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository){
        return args -> {
            List<Long> customersIds = List.of(1L, 2L, 3L);
            List<Long> productsIds = List.of(1L, 2L, 3L);
            customersIds.forEach(customersId -> {
                Bill bill = new Bill();
                bill.setCustomerId(customersId);
                bill.setBillingDate(new Date());
                billRepository.save(bill);
                productsIds.forEach(productsId -> {
                    ProductItem productItem = new ProductItem();
                    productItem.setProductId(productsId);
                    productItem.setPrice(1000 * Math.random());
                    productItem.setQuantity(1 + new Random().nextInt(20));
                    productItem.setBill(bill);
                    productItemRepository.save(productItem);

                });
            });


        };
    }

}
