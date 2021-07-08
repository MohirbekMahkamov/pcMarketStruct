package uz.pdp.pcmarketstruct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.pcmarketstruct.entity.Category;
import uz.pdp.pcmarketstruct.entity.order.OrderProductCountDatabase;

public interface OrderProductCountRepository extends JpaRepository<OrderProductCountDatabase,Integer> {



}
