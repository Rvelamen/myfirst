package com.rvelamen.springmvc.controller;

import com.rvelamen.springmvc.pojo.Admin;
import com.rvelamen.springmvc.pojo.User;
import com.rvelamen.springmvc.service.LoginService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by 林继锐 on 2018/10/12.
 */
@Controller
@RequestMapping("user")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/loginAdmin")
    @ResponseBody
    public boolean toLogin(HttpSession session,@RequestBody Admin admin) throws IOException {
        if(this.loginService.check(admin)){
            session.setAttribute("username",admin.getAdminName());
            return true;
        }else{
            return false;
        }
    }

    @RequestMapping("/validate")
    @ResponseBody
    public boolean validate(@RequestBody(required = false) String adminName){
        JSONObject json = JSONObject.fromObject(adminName);
        String form = json.getString("adminName");
        System.out.println(form);
        if(this.loginService.check1(form)){
            System.out.println("运用时间啦......");
            return true;
        }
        return false;
    }

}
