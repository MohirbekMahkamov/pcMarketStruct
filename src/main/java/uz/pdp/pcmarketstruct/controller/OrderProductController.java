package uz.pdp.pcmarketstruct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pcmarketstruct.entity.order.OrderProduct;
import uz.pdp.pcmarketstruct.service.OrderProductService;

@RestController
@RequestMapping("api/orderProduct")
public class OrderProductController {

    @Autowired
    OrderProductService orderProductService;
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','ADMIN','OPERATOR')")
    @GetMapping
    public HttpEntity<?> getOrderProduct(){
        return orderProductService.getOrderProduct();
    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','ADMIN','OPERATOR')")
    @GetMapping("/{id}")
    public HttpEntity<?> getByIdOrderProduct(@PathVariable Integer id){
        return orderProductService.getByIdOrderProduct(id);
    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','ADMIN')")
    @PostMapping
    public HttpEntity<?> addOrderProduct(@RequestBody OrderProduct orderProduct){

        return orderProductService.addOrderProduct(orderProduct);

    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','ADMIN')")
    @PutMapping("/{id}")
    public HttpEntity<?> editOrderProduct(@RequestBody OrderProduct orderProduct, @PathVariable Integer id){
        return orderProductService.editOrderProduct(id,orderProduct);
    }
    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteOrderProduct(@PathVariable Integer id){
        return  orderProductService.deleteOrderProduct(id);
    }

}
