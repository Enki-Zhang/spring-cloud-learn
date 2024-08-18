package client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import user.User;

/**
 * @author Enki
 * @ClassName UserClient
 * @Description: TODO
 * @Date 2024/8/18 14:50
 * @Version 1.0
 */
@FeignClient("userservice")
public interface UserClient {
    @GetMapping("user/{id}")
    User findById(@PathVariable("id") Long id);
}

