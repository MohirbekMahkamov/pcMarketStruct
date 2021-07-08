package uz.pdp.pcmarketstruct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.pcmarketstruct.entity.Product;
import uz.pdp.pcmarketstruct.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public HttpEntity<?> getProduct(){


        return ResponseEntity.ok( productRepository.findAll());
    }

    public HttpEntity<?> addProduct(Product product){

        return ResponseEntity.ok(productRepository.save(product));

    }
    public Product editProduct(Integer id, Product product){
        Optional<Product> productRepositoryById = productRepository.findById(id);
        if (!productRepositoryById.isPresent()){
            return null;
        }
        Product editingProduct = productRepositoryById.get();
        editingProduct.setName(product.getName());
        editingProduct.setPrice(product.getPrice());
        editingProduct.setParams(product.getParams());
        editingProduct.setQuantity(product.getQuantity());
        editingProduct.setCategoryDatabase(product.getCategoryDatabase());
        return productRepository.save(editingProduct);
    }

    public HttpEntity<?> deleteProduct(Integer id){
        Optional<Product> productRepositoryById = productRepository.findById(id);
        if (productRepositoryById.isPresent()) {
            productRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(productRepositoryById.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }
    public HttpEntity<?> getProduct(Integer id){
        Optional<Product> productRepositoryById = productRepository.findById(id);
        return ResponseEntity.status(productRepositoryById.isPresent()? 202:404).body(productRepositoryById);
    }
}
