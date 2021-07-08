package uz.pdp.pcmarketstruct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.pcmarketstruct.entity.Product;
import uz.pdp.pcmarketstruct.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {



}
