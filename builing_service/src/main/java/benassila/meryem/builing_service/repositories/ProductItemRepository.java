package benassila.meryem.builing_service.repositories;

import benassila.meryem.builing_service.entities.Bill;
import benassila.meryem.builing_service.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {
    List<ProductItem> findByBillId(Long billid);
}
