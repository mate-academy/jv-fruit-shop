package core.basesyntax.write;

import core.basesyntax.Sum;
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
        String x = "";
        String head = "fruit, quantity\n";
        Sum operation = new Sum();
        List<String> listOfFruit = new ArrayList<>();
        List<String> resultList;
        OrderDao<Supply> orderDao = new OrderDaoImpl();
        List<Supply> result = orderDao.getAll();
        for (Supply row : result) {
            listOfFruit.add(row.getTypeOfFruit());
        }
        resultList = listOfFruit.stream().distinct().collect(Collectors.toList());
        for (int i = 0; i < resultList.size(); i++) {
            x += resultList.get(i) + " " + operation.sum(result, resultList.get(i)) + "\n";
        }
            System.out.println(x);
            resultList.add(head);
            try (FileWriter writer = new FileWriter("notes2.csv", false)) {
                String text = head + x;
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