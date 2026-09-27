package benassila.meryem.builing_service.feign;

import benassila.meryem.builing_service.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service") //pour appeller un microservices //on fait le nom de microservice(dans ap.propreties)
public interface CustomerServiceRestClient {
    @CircuitBreaker(name = "customer-service" ,fallbackMethod = "getDefaultCustomer")
    //qu'on j'apelle cette méthode circuitBreaker qui l'apelle et si  cette méthode génére une exception circuit breaker va apeller la methoode par default pour générer un customer par défaut
    @GetMapping("/customers/{id}")//Quand j'appelle cette méthode Java, fais-moi une requête HTTP GET vers /customers/{id}
    Customer findCustomreById(@PathVariable Long id);
    default Customer getDefaultCustomer(Long id , Exception exception){
        //normalemnt on fait pas ceci en productions on peut chercher dans la cache pour les dernières données connues
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("default customer name ");
        customer.setEmail("default@gmail.com ");
        return customer;
    }
}
