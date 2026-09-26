package benassila.meryem.builing_service.repositories;

import benassila.meryem.builing_service.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Long> {
}
