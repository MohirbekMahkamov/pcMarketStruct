package uz.pdp.pcmarketstruct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pcmarketstruct.entity.Category;
import uz.pdp.pcmarketstruct.service.CategoryService;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping("api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','ADMIN','OPERATOR')")
    @GetMapping
    public HttpEntity<?> getCategory(){
        return categoryService.getCategory();
    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','ADMIN')")
    @GetMapping("/{id}")
    public HttpEntity<?> getByIdCategory(@PathVariable Integer id){
        return categoryService.getByIdCategory(id);
    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','ADMIN')")
    @PostMapping
    public HttpEntity<?> addCategory(@RequestBody Category category){

        return categoryService.addCategory(category);

    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','ADMIN')")
    @PutMapping("/{id}")
    public HttpEntity<?> editCategory(@RequestBody Category category, @PathVariable Integer id){
        return categoryService.editCategory(id,category);
    }
    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteCategory(@PathVariable Integer id){
        return  categoryService.deleteCategory(id);
    }



}
