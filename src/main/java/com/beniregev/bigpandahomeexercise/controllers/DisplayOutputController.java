package com.beniregev.bigpandahomeexercise.controllers;

import com.beniregev.bigpandahomeexercise.services.CountersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("DisplayOutputController")
public class DisplayOutputController {
    @Autowired
    CountersService countService;

    @GetMapping("/test")
    public String test() {
        return "<body><p><b>Test</body>";
    }

    @GetMapping("/countEventsTypes")
    public String countTypes(){
        return countService.printEventsTypesCounter();
    }

    @GetMapping("/countWords")
    public String countWords(){
        return countService.printWordsCounter();
    }

}
