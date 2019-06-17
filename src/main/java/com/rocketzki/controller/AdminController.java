package com.rocketzki.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/rest/admin/me")
    @ResponseBody
    public String getAdminResponse() {
        return "Howdy you Admin Person.";
    }


}
