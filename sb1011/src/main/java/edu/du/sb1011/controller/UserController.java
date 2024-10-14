package edu.du.sb1011.controller;

import edu.du.sb1011.dto.UserDto;
import edu.du.sb1011.service.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/board/loginForm";
    }


    @GetMapping("/board/loginForm")
    public String loginForm() {
        return "board/loginForm";
    }


    @PostMapping("/board/login")
    public String login(@RequestParam("id") String id, @RequestParam String password, Model model, HttpSession session) {
        UserDto user = userServiceImpl.getUserByIdAndPassword(id, password);
        if(user != null){
            session.setAttribute("user", user);
            model.addAttribute("user", user);
            return "redirect:/board/openBoardList.do";
        }else {
            model.addAttribute("error","Invalid username or password");
            return "/board/loginForm";
        }
    }

}
