package com.atguigu.share;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * projectName: com.atguigu.share
 *
 * @author: 赵伟风
 * description: 演示共享域对象获取
 */

@Controller
@RequestMapping("share")
@ResponseBody
public class ShareController {

    @Autowired
    private ServletContext servletContext;

    //原生api
    public  void  data(HttpServletRequest request , HttpSession session){

    }


    //springmvc提供的方法： request提供了几种 {了解}
    // model modelMap map modelAndView

    public void data1(Model model){
        model.addAttribute("key","value"); //request
    }

    public void data1(ModelMap model){
        model.addAttribute("key","value"); //request
    }

    public void data1(Map map){
        map.put("key","value"); //request
    }

    public ModelAndView data1(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key","value");
        modelAndView.setViewName("试图名 页面名称");
        return modelAndView;
    }
}
