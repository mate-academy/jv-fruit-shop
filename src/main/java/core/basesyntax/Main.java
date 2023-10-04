package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.CsvReaderService;
import core.basesyntax.service.CsvWriterService;
import core.basesyntax.service.DataConvertor;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.impl.ActivityWorkerServiceImpl;
import core.basesyntax.service.impl.CsvReaderServiceImpl;
import core.basesyntax.service.impl.CsvWriterServiceImpl;
import core.basesyntax.service.impl.DataConvertorImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.strategy.ActivityHandler;
import core.basesyntax.service.strategy.ActivityStrategyImpl;
import core.basesyntax.service.strategy.BalanceActivityHandler;
import core.basesyntax.service.strategy.PurchaseActivityHandler;
import core.basesyntax.service.strategy.ReturnActivityHandler;
import core.basesyntax.service.strategy.SupplyActivityHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        // read data from file
        CsvReaderService csvReaderServiceImpl = new CsvReaderServiceImpl();
        List<String> input = csvReaderServiceImpl.readFromFile(INPUT_FILE_PATH);

        Map<Fruit.Operation, ActivityHandler> activitiesServiceMap = new HashMap<>();
        activitiesServiceMap.put(Fruit.Operation.BALANCE, new BalanceActivityHandler());
        activitiesServiceMap.put(Fruit.Operation.PURCHASE, new PurchaseActivityHandler());
        activitiesServiceMap.put(Fruit.Operation.SUPPLY, new SupplyActivityHandler());
        activitiesServiceMap.put(Fruit.Operation.RETURN, new ReturnActivityHandler());

        //convert data from file to Java object
        FruitDao fruitDao = new FruitDaoImpl();
        DataConvertor dataConvertor = new DataConvertorImpl();
        List<Fruit> fruits1 = dataConvertor.convertData(input);

        //process Java object
        ActivityWorkerServiceImpl quantModServ = new ActivityWorkerServiceImpl(
                new ActivityStrategyImpl(activitiesServiceMap), fruitDao);
        quantModServ.modifyQuantity(fruits1);

        //create reportService
        ReportCreatorService reportService = new ReportCreatorServiceImpl(fruitDao);
        String report = reportService.createReport();

        //write reportService to file
        CsvWriterService csvWriterService = new CsvWriterServiceImpl();
        csvWriterService.writeToFile(OUTPUT_FILE_PATH, report);
    }
}
