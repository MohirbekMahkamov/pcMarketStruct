package uz.pdp.pcmarketstruct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pcmarketstruct.entity.Product;
import uz.pdp.pcmarketstruct.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','ADMIN','OPERATOR')")
    @GetMapping
    public HttpEntity<?> getProduct(){
        return productService.getProduct();
    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','ADMIN')")
    @PostMapping("/add")
    public HttpEntity<?> addProduct(@RequestBody Product product){
        return productService.addProduct(product);

    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','ADMIN')")
    @PutMapping("/{id}")
    public HttpEntity<?> editProduct(@PathVariable Integer id, @RequestBody Product product){
        Product editProduct = productService.editProduct(id, product);
        return ResponseEntity.status(editProduct != null ? 202:409).body(editProduct);

    }
    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteProduct(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }

    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','ADMIN','OPERATOR')")
    @GetMapping("/{id}")
    public HttpEntity<?> getProduct(@PathVariable Integer id){

        return ResponseEntity.ok(productService.getProduct(id));
    }



}
