package uz.pdp.pcmarketstruct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.pcmarketstruct.entity.Category;
import uz.pdp.pcmarketstruct.entity.Product;

public interface CategoryRepository extends JpaRepository<Category,Integer> {



}
