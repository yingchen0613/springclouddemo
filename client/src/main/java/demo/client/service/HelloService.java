package demo.client.service;

import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "helloservice")
public interface HelloService {
    //@RequestMapping(value = "/",method = RequestMethod.GET)
    @RequestLine("GET /")
    String hello();

}
