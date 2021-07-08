package uz.pdp.pcmarketstruct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.pcmarketstruct.entity.Category;
import uz.pdp.pcmarketstruct.repository.CategoryRepository;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public HttpEntity<?> getCategory() {

        return ResponseEntity.ok(categoryRepository.findAll());
    }

    public HttpEntity<?> getByIdCategory(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return ResponseEntity.status(optionalCategory.isPresent()? 202:404).body(optionalCategory);
    }

    public HttpEntity<?> addCategory(Category category) {

        return ResponseEntity.ok(categoryRepository.save(category));

    }

    public HttpEntity<?> editCategory(Integer id, Category category) {
        Optional<Category> categoryRepositoryById = categoryRepository.findById(id);
        if (categoryRepositoryById.isPresent()){
            Category editCategory = categoryRepositoryById.get();
            category.setName(editCategory.getName());
            category.setParentId(editCategory.getParentId());
            category.setProductDatabase(editCategory.getProductDatabase());
            return ResponseEntity.ok().body(categoryRepository.save(category));
        }
            return ResponseEntity.status(404).body(categoryRepositoryById);
    }

    public HttpEntity<?> deleteCategory(Integer id) {
        Optional<Category> byId = categoryRepository.findById(id);
        return ResponseEntity.status(byId.isPresent()?202:404).body(byId);

    }
}
