package com.juju.controller;

import com.juju.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplatel;


    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return restTemplatel.getForObject("http://provider/student/findAll",Collection.class);
    }

    @GetMapping("/index")
    public String index(){
        return restTemplatel.getForObject("http://provider/student/index",String.class);
    }

}
