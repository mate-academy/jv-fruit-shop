package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ActivitiesService;
import core.basesyntax.service.CsvReaderService;
import core.basesyntax.service.CsvWriterService;
import core.basesyntax.service.DaoService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.impl.CsvReaderServiceImpl;
import core.basesyntax.service.impl.CsvWriterServiceImpl;
import core.basesyntax.service.impl.DaoServiceImpl;
import core.basesyntax.service.impl.QuantityModificationServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.strategy.ActivityStrategyImpl;
import core.basesyntax.service.strategy.Balance;
import core.basesyntax.service.strategy.Purchase;
import core.basesyntax.service.strategy.Return;
import core.basesyntax.service.strategy.Supply;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // read data from file
        CsvReaderService csvReaderServiceImpl = new CsvReaderServiceImpl();
        String path = "src/main/resources/input.csv";
        List<String> input = csvReaderServiceImpl.readFromFile(path);
        //convert data from file to Java object
        FruitDao newDao = new FruitDaoImpl();
        DaoService daoService = new DaoServiceImpl(newDao);
        daoService.convertData(input);
        //process Java object
        Map<Fruit.Operation, ActivitiesService> activitiesServiceMap = new HashMap<>();
        activitiesServiceMap.put(Fruit.Operation.BALANCE, new Balance());
        activitiesServiceMap.put(Fruit.Operation.PURCHASE, new Purchase());
        activitiesServiceMap.put(Fruit.Operation.SUPPLY, new Supply());
        activitiesServiceMap.put(Fruit.Operation.RETURN, new Return());
        QuantityModificationServiceImpl quantModServ = new QuantityModificationServiceImpl(
                new ActivityStrategyImpl(activitiesServiceMap), newDao);
        List<Fruit> fruits = quantModServ.modifyQuantity();
        //create report
        ReportCreatorService report = new ReportCreatorServiceImpl();
        Map<String, Integer> report1 = report.createReport(fruits);
        //write report to file
        CsvWriterService csvWriterService = new CsvWriterServiceImpl();
        csvWriterService.writeToReport("src/main/resources/report.csv", report1);
    }
}
