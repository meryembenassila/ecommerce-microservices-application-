package benassila.meryem.builing_service.repositories;

import benassila.meryem.builing_service.entities.Bill;
import benassila.meryem.builing_service.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {
    List<ProductItem> findByBillId(Long billid);
}
