package core.basesyntax.model;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.OperationStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StoreImpl implements Store {
    private List<Fruit> fruits;
    private FruitService fruitService;
    private FruitsDao fruitsDao;

    public StoreImpl(OperationStrategy operationStrategy) {
        fruits = new ArrayList<>();
        fruitsDao = new FruitsDaoImpl();
        fruitService = new FruitServiceImpl(fruitsDao, operationStrategy);
    }

    @Override
    public void getStatistic(String filePath) {
        fruitService.getDataFromFile(filePath);
        fruits = fruitService.getFruitsBalance(fruitsDao.getData());
        System.out.println(fruits.toString());
    }

    // TODO: create a class to work with files
    private void printInFile(File file) {

    }
}
