package benassila.meryem.builing_service.feign;

import benassila.meryem.builing_service.model.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service") //quelle nom de service je pose ici
public interface InventoryServiceRestClient {
    @CircuitBreaker(name = "inventory-service",fallbackMethod = "getDefaultProduct")
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id);
    default Product getDefaultProduct(Long id , Exception exception){
        //normalemnt on fait pas ceci en productions on peut chercher dans la cache pour les dernières données connues
        Product product = new Product();
        product.setId(id);
        product.setName("product indisponible ");

        return product;
    }
}
