package com.example.user.controller;
import com.example.user.util.Result;

import com.example.user.pojo.User;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // 进入登录页
    @RequestMapping("/")
    public String login() {
        return "login";
    }

    // 处理登录请求
    @PostMapping("/login")
    public String login(String username, String password, HttpSession session) {
        User user = userService.checkUserByUsernameAndPassword(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/user/list";
        } else {
            return "login";
        }
    }
    // 用户列表页面
    @GetMapping("/user/list")
    public String list(Model model) {
        List<User> userList = userService.selectAll();
        model.addAttribute("userList", userList);
        return "list";
    }

    // 进入添加用户页面
    @GetMapping("/user/add")
    public String toAdd() {
        return "add";
    }

    //添加用户
    @PostMapping("/add")
    public Result add(@RequestBody User user) {
        int result = userService.add(user);
        if (result > 0) {
            return Result.success("添加用户成功！");
        } else {
            return Result.error("添加用户失败！");
        }
    }

    // 进入修改用户页面
    @GetMapping("/user/edit/{id}")
    public String toEdit(@PathVariable("id") int id, Model model) {
        List<User> user = userService.selectById(String.valueOf(id));
        model.addAttribute("user", user);
        return "edit";
    }

    // 处理修改用户请求
    @PutMapping("/user/edit")
    public String edit(User user) {
        userService.update(user);
        return "redirect:/user/list";
    }

    // 处理删除用户请求
    @DeleteMapping("/user/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/user/list";
    }

}
