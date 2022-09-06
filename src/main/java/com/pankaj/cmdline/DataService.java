package com.pankaj.cmdline;

import org.springframework.stereotype.Service;

@Service
public class DataService {
    public String getMessage(String name){
        return "Hello from Service ! = " + name;
    }
}
