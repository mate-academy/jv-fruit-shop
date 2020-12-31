package core.basesyntax.model;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.service.*;
import java.util.ArrayList;
import java.util.List;

public class FruitStoreImpl implements Store {
    private List<Fruit> fruits;
    private FruitService fruitService;
    private FruitsDao fruitsDao;

    public FruitStoreImpl(OperationStrategy operationStrategy) {
        fruits = new ArrayList<>();
        fruitsDao = new FruitsDaoImpl();
        fruitService = new FruitServiceImpl(fruitsDao, operationStrategy);
    }

    @Override
    public void getStatistic(String fromFile_Path, String toFile_Path) {
        fruitService.getDataFromFile(fromFile_Path);
        fruits = fruitService.getFruitsBalance(fruitsDao.getData());
        FileWriterService fileWriterService = new FileWriterServiceImpl(toFile_Path);
        fileWriterService.writeToFile(createReport());
    }

    private String createReport() {
        StringBuilder result = new StringBuilder();
        result.append("fruit,quantity").append(System.lineSeparator());
        for (Fruit fruit : fruits) {
            result.append(fruit.getName()).append(",").append(fruit.getBalance())
                    .append(System.lineSeparator());
        }
        return result.toString();
    }
}
