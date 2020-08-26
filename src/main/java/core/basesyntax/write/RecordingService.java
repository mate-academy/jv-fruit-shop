package core.basesyntax.write;

import core.basesyntax.dao.OrderDao;
import core.basesyntax.dao.OrderDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.operation.OperationGeneral;
import core.basesyntax.operation.Supply;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecordingService {
    public void writingToFile() {
        int s = 0;
        String head = "fruit, quantity\n";
        List<String> resultList = new ArrayList<>();
        OrderDao<Supply> orderDao = new OrderDaoImpl();
        List<Supply> result = orderDao.getAll();
        System.out.println(result);

        int sum = result.stream()
                .filter(x -> x.getTypeOfFruit().equals("apple"))
                .map(x -> x.getTypeOfOperation().equals("b")
                        ? -(x.getQuantity())
                        : x.getQuantity())
                .reduce(0, Integer::sum);
        resultList.add(head);
        resultList.add(String.valueOf(sum));
        try (FileWriter writer = new FileWriter("notes2.csv", false)) {
            String text = resultList.toString();
            writer.write(text);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

}

//        for (Supply supply : result) {

//            s = supply.getQuantity();
//        }
//        int amountOfApple = orderDao.getAll().stream()
//                .filter(x -> x.getFruit().equals("apple"))
//                .map(x -> x.getType().equals("b")
//                        ? -(x.getQuantity())
//                        : x.getQuantity())
//                .reduce(0, Integer::sum);
//        System.out.println(orderDao.getAll());