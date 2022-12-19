package ru.croc.task17.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.croc.task17.model.Product;

public interface ProductDAO extends JpaRepository<Product, Long> {
}
