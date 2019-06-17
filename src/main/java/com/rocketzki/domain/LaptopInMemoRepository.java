package com.rocketzki.domain;

import com.rocketzki.domain.model.Laptop;
import com.rocketzki.repository.InMemoRepository;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class LaptopInMemoRepository implements InMemoRepository<Laptop> {

    private List<Laptop> laptops;

    LaptopInMemoRepository() {
        laptops = Arrays.asList(new Laptop("MSI", "GE62", 4556.3, "AMD"),
                new Laptop("Lenovo", "G60", 3000.0, "Intel"));
    }

    public List<Laptop> getItems() {
        return laptops;
    }
}
