package com.rocketzki.controller;

import com.rocketzki.domain.LaptopService;
import com.rocketzki.domain.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class LaptopController {

    private LaptopService laptopService;

    @Autowired
    private void setLaptopService(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @GetMapping("/laptops")
    @ResponseBody
    public List<Laptop> getAllLaptops() {
        return laptopService.getLaptops();
    }

    @GetMapping("/laptop/{id}")
    @ResponseBody
    public Laptop getById(@PathVariable("id") Integer id) {
        return laptopService.getById(id);
    }

    @PostMapping("/laptop/add")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String addOne(@RequestBody Laptop laptop) {
        laptopService.addLaptop(laptop);
        return "Laptop: " + laptop.toString() + " has been added.";
    }


}
