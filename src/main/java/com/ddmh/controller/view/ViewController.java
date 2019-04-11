package com.ddmh.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author FBin
 * @version 2019/4/11 16:55
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    @RequestMapping("/index")
    public String viewIndex(){
        return "index";
    }

}
