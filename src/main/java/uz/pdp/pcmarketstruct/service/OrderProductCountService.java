package uz.pdp.pcmarketstruct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import uz.pdp.pcmarketstruct.entity.order.OrderProductCountDatabase;
import uz.pdp.pcmarketstruct.repository.OrderProductCountRepository;


import java.util.Optional;

@Service
public class OrderProductCountService {
    @Autowired
    OrderProductCountRepository orderProductCountRepository;

    public HttpEntity<?> getOrderProductCount() {

        return ResponseEntity.ok(orderProductCountRepository.findAll());
    }

    public HttpEntity<?> getByIdOrderProductCount(Integer id) {
        Optional<OrderProductCountDatabase> optionalOrderProductCount = orderProductCountRepository.findById(id);
        return ResponseEntity.status(optionalOrderProductCount.isPresent()? 202:404).body(optionalOrderProductCount);
    }

    public HttpEntity<?> addOrderProductCount(OrderProductCountDatabase orderProductCount) {

        return ResponseEntity.ok(orderProductCountRepository.save(orderProductCount));

    }

    public HttpEntity<?> editOrderProductCount(Integer id, OrderProductCountDatabase orderProductCount) {
        Optional<OrderProductCountDatabase> orderProductCountRepositoryById = orderProductCountRepository.findById(id);
        if (orderProductCountRepositoryById.isPresent()){
            OrderProductCountDatabase editOrderProductCount = orderProductCountRepositoryById.get();
            orderProductCount.setProductId(editOrderProductCount.getProductId());
            orderProductCount.setProductOrderCount(editOrderProductCount.getProductOrderCount());


            return ResponseEntity.ok().body(orderProductCountRepository.save(orderProductCount));
        }
        return ResponseEntity.status(404).body(orderProductCountRepositoryById);
    }

    public HttpEntity<?> deleteOrderProductCount(Integer id) {
        Optional<OrderProductCountDatabase> byId = orderProductCountRepository.findById(id);
        return ResponseEntity.status(byId.isPresent()?202:404).body(byId);

    }



}
