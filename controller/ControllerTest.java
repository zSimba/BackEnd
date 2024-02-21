package es.darcalzadilla.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class ControllerTest {

    @GetMapping("/test")
    public String test(){
        return "Test";
    }
}
