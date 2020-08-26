package core.basesyntax.write;

import core.basesyntax.dao.OrderDao;
import core.basesyntax.dao.OrderDaoImpl;

import java.io.FileWriter;
import java.io.IOException;

public class RecordingService {
    public void writingToFile() {
        OrderDao orderDao = new OrderDaoImpl();

        int amountOfBananas = orderDao.getAll().stream()
                .filter(x -> x.getFruit().equals("banana"))
                .map(x -> x.getType().equals("b")
                        ? -(x.getQuantity())
                        : x.getQuantity())
                .reduce(0, Integer::sum);

        int amountOfOrange = orderDao.getAll().stream()
                .filter(x -> x.getFruit().equals("orange"))
                .map(x -> x.getType().equals("b")
                        ? -(x.getQuantity())
                        : x.getQuantity())
                .reduce(0, Integer::sum);

        int amountOfApple = orderDao.getAll().stream()
                .filter(x -> x.getFruit().equals("apple"))
                .map(x -> x.getType().equals("b")
                        ? -(x.getQuantity())
                        : x.getQuantity())
                .reduce(0, Integer::sum);
        System.out.println(orderDao.getAll());


        try (FileWriter writer = new FileWriter("notes3.csv", false)) {
            String text = "Fruit, Quantity" + "\n"
                    + "banana, " + amountOfBananas + "\n"
                    + "orange, " + amountOfOrange + "\n"
                    + "apple, " + amountOfApple;
            writer.write(text);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

}
