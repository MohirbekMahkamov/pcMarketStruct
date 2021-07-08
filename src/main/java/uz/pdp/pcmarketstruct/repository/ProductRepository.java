package uz.pdp.pcmarketstruct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.pcmarketstruct.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {



}
