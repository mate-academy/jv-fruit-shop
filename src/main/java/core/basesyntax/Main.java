package core.basesyntax;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.db.Storage;

public class Main {
    public static void main(String[] args) {
        FruitsDao fruitsDao = new FruitsDaoImpl();
        fruitsDao.add("banana", 200);
        fruitsDao.add("banana", 300);
        fruitsDao.add("orange", 100);
        fruitsDao.subtract("banana", 50);

        System.out.println(Storage.fruits);
    }
}
