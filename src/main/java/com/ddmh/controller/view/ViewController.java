package com.ddmh.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author FBin
 * @version 2019/4/11 16:55
 */
@Controller
public class ViewController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

}
