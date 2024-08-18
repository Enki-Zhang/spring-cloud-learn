package cn.itcast.user.controller;

import cn.itcast.user.config.NacosConfig;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Enki
 * @ClassName UserController
 * @Description: TODO
 * @Date 2024/8/17 10:57
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private NacosConfig nacosConfig;

//    @Value("${pattern.dateformat}")
//    private String dateformat;
//    @Value("${pattern.say}")
//    private String say1;


    @GetMapping("/now")

    public String now() {
        System.out.println(nacosConfig.getSay());
        System.out.println("时间" + nacosConfig.getAa() + nacosConfig.getSay());
        return null;
    }


    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }
}
