package com.rocketzki.repository;

import java.util.List;

public interface InMemoRepository<T> {

    List<T> getItems();
    void addItem(T item);

}
