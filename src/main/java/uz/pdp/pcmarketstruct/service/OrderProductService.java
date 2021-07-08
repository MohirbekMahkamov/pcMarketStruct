package uz.pdp.pcmarketstruct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.pcmarketstruct.entity.order.OrderProduct;
import uz.pdp.pcmarketstruct.repository.OrderProductRepository;

import java.util.Optional;

@Service
public class OrderProductService {
    @Autowired
    OrderProductRepository orderProductRepository;

    public HttpEntity<?> getOrderProduct() {

        return ResponseEntity.ok(orderProductRepository.findAll());
    }

    public HttpEntity<?> getByIdOrderProduct(Integer id) {
        Optional<OrderProduct> optionalOrderProduct = orderProductRepository.findById(id);
        return ResponseEntity.status(optionalOrderProduct.isPresent()? 202:404).body(optionalOrderProduct);
    }

    public HttpEntity<?> addOrderProduct(OrderProduct orderProduct) {

        return ResponseEntity.ok(orderProductRepository.save(orderProduct));

    }

    public HttpEntity<?> editOrderProduct(Integer id, OrderProduct orderProduct) {
        Optional<OrderProduct> orderProductRepositoryById = orderProductRepository.findById(id);
        if (orderProductRepositoryById.isPresent()){
            OrderProduct editOrderProduct = orderProductRepositoryById.get();
            orderProduct.setOrderProductCountDatabases(editOrderProduct.getOrderProductCountDatabases());
            orderProduct.setStateId(editOrderProduct.getStateId());
            orderProduct.setTotalSum(editOrderProduct.getTotalSum());
            orderProduct.setUserDatabase(editOrderProduct.getUserDatabase());


            return ResponseEntity.ok().body(orderProductRepository.save(orderProduct));
        }
        return ResponseEntity.status(404).body(orderProductRepositoryById);
    }

    public HttpEntity<?> deleteOrderProduct(Integer id) {
        Optional<OrderProduct> byId = orderProductRepository.findById(id);
        return ResponseEntity.status(byId.isPresent()?202:404).body(byId);

    }



}
