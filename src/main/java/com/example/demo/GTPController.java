package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GTPController {

    private static final String template = "This is test gtp named %s!";

    @GetMapping("/test")
    public GTPItem test(@RequestParam(value = "name", defaultValue = "Song") String name) {
        return new GTPItem("1",
                           String.format(template, name),
                           1,2,3,4,
                           "q","d", true, false, false);
    }
}