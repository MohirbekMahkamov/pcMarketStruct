package uz.pdp.pcmarketstruct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pcmarketstruct.entity.User;
import uz.pdp.pcmarketstruct.service.UserService;


@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService userService;
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','ADMIN','OPERATOR')")
    @GetMapping
    public HttpEntity<?> getUser(){
        return userService.getUser();
    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','ADMIN','OPERATOR')")
    @GetMapping("/{id}")
    public HttpEntity<?> getByIdUser(@PathVariable Integer id){
        return userService.getByIdUser(id);
    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','ADMIN')")
    @PostMapping
    public HttpEntity<?> addUser(@RequestBody User user){

        return userService.addUser(user);

    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','ADMIN')")
    @PutMapping("/{id}")
    public HttpEntity<?> editUser(@RequestBody User user, @PathVariable Integer id){
        return userService.editUser(id,user);
    }
    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteUser(@PathVariable Integer id){
        return  userService.deleteUser(id);
    }

}
