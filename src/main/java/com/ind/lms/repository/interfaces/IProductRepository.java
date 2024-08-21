package com.ind.lms.repository.interfaces;

import com.ind.lms.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Product, Integer> {
}
