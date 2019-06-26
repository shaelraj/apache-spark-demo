package com.javamonks.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javamonks.service.WordCountService;

@RestController
public class WordCountController {
 
    @Autowired
    WordCountService service;
 
    @RequestMapping(method = RequestMethod.POST, path = "/wordcount")
    public Map<String, Long> count(@RequestBody String words) {
        List<String> wordList = Arrays.asList(words.split("\\|"));
        return service.getCount(wordList);
    }
}