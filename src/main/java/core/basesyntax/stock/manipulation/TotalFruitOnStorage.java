package core.basesyntax.stock.manipulation;

import core.basesyntax.stock.dao.OrderDaoImpl;
import java.util.List;

public class TotalFruitOnStorage {
    public String totalFruit() {
        GetTotalSumOfFruit operation = new GetTotalSumOfFruit();
        OrderDaoImpl orderDao = new OrderDaoImpl();
        String totalFruitOnStorage = "";
        FruitList fruitList = new FruitList();
        List<String> listOfFruit = fruitList.createListOfFruit(orderDao.getAll());
        fruitList.createListOfFruit(orderDao.getAll());
        for (String fruit : listOfFruit) {
            totalFruitOnStorage += fruit + " " + operation.sum(orderDao.getAll(), fruit) + "\n";
        }
        return totalFruitOnStorage;
    }
}
