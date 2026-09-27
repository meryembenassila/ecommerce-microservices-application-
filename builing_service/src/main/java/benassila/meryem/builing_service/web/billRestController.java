package benassila.meryem.builing_service.web;

import benassila.meryem.builing_service.entities.Bill;
import benassila.meryem.builing_service.feign.CustomerServiceRestClient;
import benassila.meryem.builing_service.feign.InventoryServiceRestClient;
import benassila.meryem.builing_service.model.Customer;
import benassila.meryem.builing_service.model.Product;
import benassila.meryem.builing_service.repositories.BillRepository;
import benassila.meryem.builing_service.repositories.ProductItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor

public class billRestController {

    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerServiceRestClient customerServiceRestClient;
    private InventoryServiceRestClient inventoryServiceRestClient;



    @GetMapping("/factures/{id}")
    public Bill getBillById(@PathVariable  Long id){
        Bill bill = billRepository.findById(id).get();
        System.out.println(bill.getId());
        Customer customer = customerServiceRestClient.findCustomreById(bill.getCustomerId());
        System.out.println(customer.getId());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(productItem -> {
            Product product = inventoryServiceRestClient.getProduct(productItem.getProductId());
            productItem.setProduct(product);
        });
        return bill;

    }


}
