package ru.croc.task17;

import ru.croc.task17.db.dao.DeliveryDAO;

public class Task19 {
    public static void main(String[] args) {
        DeliveryDAO.update(); // выполняется только один раз при первом запуске

        DeliveryDAO.getCourierInfo(2);

        DeliveryDAO.getUserInfo(3);

        DeliveryDAO.getUserInfo(14);

        DeliveryDAO.getUserInfo(12);
    }
}
