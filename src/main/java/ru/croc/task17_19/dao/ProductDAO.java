package ru.croc.task17_19.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.croc.task17_19.model.Product;

import java.util.Optional;

public interface ProductDAO extends JpaRepository<Product, Long> {
    Optional<Product> findByIdProductAndOrderIdOrder(Long idProduct, Long order_idOrder);
}
