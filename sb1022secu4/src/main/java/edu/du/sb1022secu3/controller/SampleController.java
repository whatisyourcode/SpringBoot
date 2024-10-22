package edu.du.sb1022secu3.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/")
@Log4j2
public class SampleController {

    @GetMapping("/accessDenied")
    public void accessDenied() {}

    @GetMapping("/admin")
    public void admin() {
        log.info("exAdmin.....");
    }

    @GetMapping("/member")
    public void member() {
        log.info("exMember.....");
    }

    @GetMapping("/all")
    public void all() {
        log.info("exAll.....");
    }

}

