package core.basesyntax.read;

import core.basesyntax.dao.OrderDao;
import core.basesyntax.dao.OrderDaoImpl;
import core.basesyntax.order.Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {
    public void readFromFile(String filePath) {
        OrderDao orderDao = new OrderDaoImpl();

        try (BufferedReader bf = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] arr1 = line.split(",");
                String type = arr1[0];
                String fruit = arr1[1];
                int quantity = Integer.parseInt(arr1[2]);
                Order order = new Order(type, fruit, quantity);
                orderDao.add(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
