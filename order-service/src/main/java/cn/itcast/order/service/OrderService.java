package cn.itcast.order.service;


import client.UserClient;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private UserClient userClient;
    @Autowired
    private OrderMapper orderMapper;
//    @Autowired
//    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
//        查询user 远程查询
//        String url = "http://userservice/user/" + order.getUserId();
//        调用
//        User user = restTemplate.getForObject(url, User.class);
        User user = userClient.findById(orderId);
        order.setUser(user);
        // 4.返回
        return order;
    }
}
