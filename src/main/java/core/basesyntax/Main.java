package core.basesyntax;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportMaker;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.Validator;
import core.basesyntax.service.Writer;
import core.basesyntax.service.activity.ActivityHandler;
import core.basesyntax.service.activity.ActivityType;
import core.basesyntax.service.activity.AddingHandler;
import core.basesyntax.service.activity.RemovingHandler;
import core.basesyntax.service.impl.ReaderCsvImpl;
import core.basesyntax.service.impl.ReportMakerImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.ValidatorImpl;
import core.basesyntax.service.impl.WriterCsvImpl;
import core.basesyntax.strategy.ActivityStrategy;
import core.basesyntax.strategy.ActivityStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILEPATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILEPATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitStorageDao fruitDao = new FruitStorageDaoImpl();

        Map<String, ActivityHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put(ActivityType.BALANCE.getName(), new AddingHandler(fruitDao));
        activityHandlerMap.put(ActivityType.PURCHASE.getName(), new RemovingHandler(fruitDao));
        activityHandlerMap.put(ActivityType.SUPPLY.getName(), new AddingHandler(fruitDao));
        activityHandlerMap.put(ActivityType.RETURN.getName(), new AddingHandler(fruitDao));
        ActivityStrategy strategy = new ActivityStrategyImpl(activityHandlerMap);

        Validator validator = new ValidatorImpl(activityHandlerMap);
        Reader fileReader = new ReaderCsvImpl();
        Writer fileWriter = new WriterCsvImpl();
        ReportMaker reportMaker = new ReportMakerImpl();
        ShopService shopService = new ShopServiceImpl(strategy, fruitDao);
        List<java.lang.String> inputData = fileReader.readFromFile(INPUT_FILEPATH);
        if (validator.validateData(inputData)) {
            List<Fruit> fruitList = shopService.updateShopWarehouse(inputData);
            java.lang.String report = reportMaker.makeReport(fruitList);
            fileWriter.writeToFile(report, OUTPUT_FILEPATH);
        }
    }
}
