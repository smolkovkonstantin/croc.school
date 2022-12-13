package ru.croc.task17;

import ru.croc.reader.MyReader;
import ru.croc.task17.db.Order;
import ru.croc.task17.db.OrderDAO;

import java.util.List;

public class Task17 {
    public static void main(String[] args) {
        List<Order> orderList = MyReader.readTask17();

        OrderDAO.create();

        orderList.forEach(OrderDAO::addOrder);

    }
}
