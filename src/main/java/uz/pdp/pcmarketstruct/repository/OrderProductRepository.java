package uz.pdp.pcmarketstruct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.pcmarketstruct.entity.order.OrderProduct;
import uz.pdp.pcmarketstruct.entity.order.OrderProductCountDatabase;

public interface OrderProductRepository extends JpaRepository<OrderProduct,Integer> {



}
