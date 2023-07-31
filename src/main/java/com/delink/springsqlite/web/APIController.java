package com.delink.springsqlite.web;

import com.delink.springsqlite.bean.User;
import com.delink.springsqlite.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname APIController
 * @Description TODO
 * @Autor cengdan
 * @Date 2023/7/3123:12
 * @Version 1.0
 */
@RestController
@RequestMapping("/")
public class APIController {
    @Resource
    private UserService userService;

    @GetMapping("/init")
    public String init(){
        User user = null;
        for(int i=0;i<10;i++){
            user = new User();
            user.setName("test"+i);
            userService.save(user);
        }
        return "初始化完成。";
    }

    @GetMapping("/userByName/{username}")
    public User getUserByName(@PathVariable("username") String username){
        return userService.getByName(username);
    }

    @GetMapping("/userById/{userid}")
    public User getUserById(@PathVariable("userid") Long userid){
        return userService.getUserByID(userid);
    }

    @GetMapping("/page")
    public Page<User> getPage(){
        return userService.findPage();
    }

    @GetMapping("/page/{maxID}")
    public Page<User> getPageByMaxID(@PathVariable("maxID") Long maxID){
        return userService.find(maxID);
    }

    @RequestMapping("/update/{id}/{name}")
    public User update(@PathVariable Long id, @PathVariable String name){
        return userService.update(id,name);
    }

    @RequestMapping("/update/{id}")
    public Boolean updateById(@PathVariable Long id){
        return userService.updateById("newName",id);
    }

}
