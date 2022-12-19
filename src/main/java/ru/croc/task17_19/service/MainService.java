package ru.croc.task17_19.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import ru.croc.task17_19.dao.OrderDAO;
import ru.croc.task17_19.dao.ProductDAO;
import ru.croc.task17_19.model.Order;
import ru.croc.task17_19.model.Product;

import java.util.Arrays;

@Service
@Getter
@Setter
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

        System.out.println(Arrays.toString(stringOrder));
        Product product = Product.builder()
                .nameProduct(stringOrder[3])
                .order(order)
                .price(Integer.parseInt(stringOrder[4]))
                .productCode(stringOrder[2])
                .build();

        orderDAO.save(order);
        productDAO.save(product);
    }
}
