package benassila.meryem.customerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "customer.params")//pour que cette annotation traville on doit activer enableConfigparams dans main
public record CustomerConfigParams (int x ,int y ){
}
