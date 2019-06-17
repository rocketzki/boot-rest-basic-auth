package com.rocketzki.domain;


import com.rocketzki.domain.model.Laptop;
import com.rocketzki.repository.InMemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LaptopService {

    private InMemoRepository<Laptop> repo;

    @Autowired
    private void setRepo(InMemoRepository<Laptop> repo) {
        this.repo = repo;
    }


    public List<Laptop> getLaptops() {
        return repo.getItems();
    }

    public void addLaptop(Laptop laptop) {
        repo.addItem(laptop);
    }

    public Laptop getById(Integer id) {
        List<Laptop> theList = repo.getItems();
        if (!theList.isEmpty() && theList.size() > id) {
            return theList.get(id);
        } else {
            throw new NoSuchElementException("There's no such element in the InMemo DB");
        }
    }
}
