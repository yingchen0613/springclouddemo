package demo.client.controller;

import demo.client.service.HelloService;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${name}")
    String name;

    @GetMapping("/")
    public String hello() {
        return "Hello " + name + "!";
    }

    @GetMapping("/hellofeign")
    public String helloFeign() {
        HelloService service = Feign.builder()
                .options(new Request.Options(1000, 3500))
                .retryer(new Retryer.Default(5000, 5000, 3))
                .target(HelloService.class, "http://localhost:54752/");

        return service.hello();
    }

}
