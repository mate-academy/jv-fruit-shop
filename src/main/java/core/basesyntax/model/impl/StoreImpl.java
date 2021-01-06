package core.basesyntax.model.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Store;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.Report;
import core.basesyntax.service.StoreService;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.StoreServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import java.util.ArrayList;
import java.util.List;

public class StoreImpl<T extends Fruit> implements Store {
    public List<T> fruits;
    public StoreService storeService;
    public FruitDao fruitsDao;

    public StoreImpl(OperationStrategy operationStrategy) {
        fruits = new ArrayList<>();
        fruitsDao = new FruitDaoImpl();
        storeService = new StoreServiceImpl(fruitsDao, operationStrategy);
    }

    @Override
    public void getInfo(String fromFilePath, String toFilePath) {
        storeService.getDataFromFile(fromFilePath);
        fruits = storeService.getFruitsBalance(fruitsDao.getData());
        CsvFileWriter fileWriterService = new CsvFileWriterImpl(toFilePath);
        Report report = new Report() {
            @Override
            public String generateReport(List list) {
                StringBuilder result = new StringBuilder();
                result.append("fruit,quantity").append(System.lineSeparator());
                fruits.forEach(fruit -> result.append(fruit.toString()));
                return result.toString();
            }
        };
        fileWriterService.writeToFile(report.generateReport(fruits));
    }
}
