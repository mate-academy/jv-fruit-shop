package core.basesyntax.model;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.Report;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class Store {
    private FruitService fruitService;
    private FruitsDao fruitsDao;

    public Store(OperationStrategy operationStrategy) {
        fruitsDao = new FruitsDaoImpl();
        fruitService = new FruitServiceImpl(fruitsDao, operationStrategy);
    }

    public void showStatistic(String fromFilePath, String toFilePath) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> dataFromFile = fileReaderService.getDataFromFile(fromFilePath);
        fruitService.calculateFruitsBalance(dataFromFile);
        Report report = fruits -> {
            StringBuilder result = new StringBuilder();
            result.append("fruit,quantity").append(System.lineSeparator());
            for (Fruit fruit : fruits) {
                result.append(fruit.getName()).append(",").append(fruit.getBalance())
                        .append(System.lineSeparator());
            }
            return result.toString();
        };
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(toFilePath, report.createReport(fruitsDao.getData()));
    }
}
