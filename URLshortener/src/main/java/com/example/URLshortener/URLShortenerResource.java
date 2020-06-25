package com.example.URLshortener;

import com.google.common.hash.Hashing;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/rest/url")
public class URLShortenerResource {

    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("/{id}")
    public String getUrl(@PathVariable("id") String id){
        String url = redisTemplate.opsForValue().get(id);
        System.out.println("URL retrieved: "+url);
        return url;
    }

    @PostMapping
    public String create(@RequestBody String url){
        UrlValidator urlValidator = new UrlValidator(new String[]{"http","https"});

        if(urlValidator.isValid(url)){
            String id = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
            System.out.println("URL id generated: "+id);
            redisTemplate.opsForValue().set(id, url);
            return id;
        }
        throw new RuntimeException("URL Invalid: "+url);
    }
}
