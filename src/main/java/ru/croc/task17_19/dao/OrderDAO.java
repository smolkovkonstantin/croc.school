package ru.croc.task17_19.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.croc.task17_19.model.Order;

public interface OrderDAO extends JpaRepository<Order, Long> {
}
