package ru.croc.task17.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.croc.task17.model.Order;

public interface OrderDAO extends JpaRepository<Order, Long> {
}
