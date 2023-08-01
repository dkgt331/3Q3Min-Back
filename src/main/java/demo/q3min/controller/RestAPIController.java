package demo.q3min.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPIController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
