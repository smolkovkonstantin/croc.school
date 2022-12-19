package ru.croc.task17.service;

import org.springframework.stereotype.Service;
import ru.croc.task17.dao.OrderDAO;
import ru.croc.task17.dao.ProductDAO;
import ru.croc.task17.model.Order;
import ru.croc.task17.model.Product;

@Service
public class MainService {

    private final OrderDAO orderDAO;
    private final ProductDAO productDAO;

    public MainService(OrderDAO orderDAO, ProductDAO productDAO) {
        this.orderDAO = orderDAO;
        this.productDAO = productDAO;
    }


    public void registerOrderAndProduct(String[] stringOrder) {
        Order order = Order.builder()
                .idOrder(Long.parseLong(stringOrder[0]))
                .customerName(stringOrder[1])
                .build();

        orderDAO.save(order);

        Product product = Product.builder()
                .idProduct(stringOrder[2])
                .nameProduct(stringOrder[3])
                .price(Integer.parseInt(stringOrder[4]))
                .order(order)
                .build();

        productDAO.save(product);
    }
}
