package com.example.demo.module.controller;

import com.example.demo.listener.MyHttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/**
 * Description: 用户控制层
 *
 * @author gan.jin@ucarinc.com
 * @version 1.0
 * @Date 2019/10/28 11:38
 */
@RestController
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${application.message:Hello World}")
    private String message ;

    @GetMapping("/asd/{name}")
    public String welcome(@PathVariable String name, Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        return "welcome";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Object foo() {
        logger.info("打印日志----------------------");
        return  "login";
    }

    @RequestMapping("/index")
    @ResponseBody
    public Object index(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.setAttribute("zxc", "zxc");
        return  "index";
    }

    @RequestMapping("/online")
    @ResponseBody
    public Object online() {
        return  "当前在线人数：" + MyHttpSessionListener.online + "人";
    }
}
