package com.geekbrains.repositories;

import com.geekbrains.entities.Category;
import com.geekbrains.entities.New;
import com.geekbrains.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NewRepository  extends CrudRepository<New, Long> {
    List<New> findAll();
}
