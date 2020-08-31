package core.basesyntax.util;

import core.basesyntax.dao.OrderDaoImpl;
import java.util.List;

public class TotalFruit {
    public String totalFruitOnStorage() {
        GetTotalSumOfFruit operation = new GetTotalSumOfFruit();
        OrderDaoImpl orderDao = new OrderDaoImpl();
        String totalFruitOnStorage = "";
        FruitList fruitList = new FruitList();
        List<String> listOfFruit = fruitList.createListOfFruit(orderDao.getAll());
        for (String fruit : listOfFruit) {
            totalFruitOnStorage += fruit + " " + operation.sum(orderDao.getAll(), fruit) + "\n";
        }
        return totalFruitOnStorage;
    }
}
