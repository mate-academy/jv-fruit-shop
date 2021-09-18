package core.basesyntax.service;

import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.Fruit;

import java.util.List;

public class FruitsService {
    FruitsDaoImpl fruitsDao = new FruitsDaoImpl();
    List<String> list = fruitsDao.readFromFile();

    public void addFruit() {
        for (String fruit : list) {
            String[] temp = fruit.split(",");
            if (temp[0].equals("b")) {
                fruitsDao.add(new Fruit(temp[1], Integer.parseInt(temp[2])));
            }
        }
    }
}
