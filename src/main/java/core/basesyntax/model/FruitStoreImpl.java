package core.basesyntax.model;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FileWriterServiceImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.Report;
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
    public void getStatistic(String fromFilePath, String toFilePath) {
        fruitService.getDataFromFile(fromFilePath);
        fruits = fruitService.getFruitsBalance(fruitsDao.getData());
        FileWriterService fileWriterService = new FileWriterServiceImpl(toFilePath);
        Report report = fruits -> {
            StringBuilder result = new StringBuilder();
            result.append("fruit,quantity").append(System.lineSeparator());
            for (Fruit fruit : fruits) {
                result.append(fruit.getName()).append(",").append(fruit.getBalance())
                        .append(System.lineSeparator());
            }
            return result.toString();
        };
        fileWriterService.writeToFile(report.createReport(fruits));
    }
}
