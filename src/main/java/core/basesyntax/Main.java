package core.basesyntax;

import core.basesyntax.activities.ActivitiesHandler;
import core.basesyntax.activities.ActivityType;
import core.basesyntax.activities.BalanceActivityHandler;
import core.basesyntax.activities.PurchaseActivityHandler;
import core.basesyntax.activities.ReturnActivityHandler;
import core.basesyntax.activities.SupplyActivityHandler;
import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.impl.CreateReportServiceImpl;
import core.basesyntax.impl.FruitStoreServiceImpl;
import core.basesyntax.impl.ReaderServiceImpl;
import core.basesyntax.impl.ValidatorServiceImpl;
import core.basesyntax.impl.WriterServiceImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.startegy.ActivitiesStrategy;
import core.basesyntax.startegy.ActivitiesStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/Input file";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/Output file";

    public static void main(String[] args) {
        FruitsDao storageDao = new FruitsDaoImpl();
        Map<ActivityType, ActivitiesHandler> activitiesHandlerMap = new HashMap<>();
        activitiesHandlerMap.put(ActivityType.BALANCE, new BalanceActivityHandler());
        activitiesHandlerMap.put(ActivityType.PURCHASE, new PurchaseActivityHandler());
        activitiesHandlerMap.put(ActivityType.RETURN, new ReturnActivityHandler());
        activitiesHandlerMap.put(ActivityType.SUPPLY, new SupplyActivityHandler());
        List<String> text = new ReaderServiceImpl().readFromFile(INPUT_FILE_PATH);
        ActivitiesStrategy activitiesStrategy = new ActivitiesStrategyImpl(activitiesHandlerMap);
        if (new ValidatorServiceImpl().isValid(text)) {
            List<Fruit> fruits = new FruitStoreServiceImpl(storageDao, activitiesStrategy)
                    .changeBalanceFruit(text);
            String report = new CreateReportServiceImpl().createReport(fruits);
            new WriterServiceImpl().writeData(OUTPUT_FILE_PATH, report);
        }
    }
}
