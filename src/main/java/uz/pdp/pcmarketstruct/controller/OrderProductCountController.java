package uz.pdp.pcmarketstruct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import uz.pdp.pcmarketstruct.entity.order.OrderProductCountDatabase;
import uz.pdp.pcmarketstruct.service.OrderProductCountService;



@RestController
@RequestMapping("api/orderProductCount")
public class OrderProductCountController {

    @Autowired
    OrderProductCountService orderProductCountService;
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','ADMIN','OPERATOR')")
    @GetMapping
    public HttpEntity<?> getOrderProductCount(){
        return orderProductCountService.getOrderProductCount();
    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','ADMIN','OPERATOR')")
    @GetMapping("/{id}")
    public HttpEntity<?> getByIdOrderProductCount(@PathVariable Integer id){
        return orderProductCountService.getByIdOrderProductCount(id);
    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','ADMIN')")
    @PostMapping
    public HttpEntity<?> addOrderProductCount(@RequestBody OrderProductCountDatabase orderProductCount){

        return orderProductCountService.addOrderProductCount(orderProductCount);

    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','ADMIN')")
    @PutMapping("/{id}")
    public HttpEntity<?> editOrderProductCount(@RequestBody OrderProductCountDatabase orderProductCount, @PathVariable Integer id){
        return orderProductCountService.editOrderProductCount(id,orderProductCount);
    }
    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteOrderProductCount(@PathVariable Integer id){
        return  orderProductCountService.deleteOrderProductCount(id);
    }

}
