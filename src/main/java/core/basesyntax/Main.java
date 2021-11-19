package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.impl.CreateReportServiceImpl;
import core.basesyntax.impl.FruitStoreServiceImpl;
import core.basesyntax.impl.ReaderServiceImpl;
import core.basesyntax.impl.ValidatorServiceImpl;
import core.basesyntax.impl.WriterServiceImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.startegy.ActivitiesService;
import core.basesyntax.startegy.ActivityType;
import core.basesyntax.startegy.impl.BalanceActivityService;
import core.basesyntax.startegy.impl.PurchaseActivityService;
import core.basesyntax.startegy.impl.ReturnActivityService;
import core.basesyntax.startegy.impl.SupplyActivityService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/Input file";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/Output file";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<ActivityType, ActivitiesService> activityMap = new HashMap<>();
        activityMap.put(ActivityType.BALANCE, new BalanceActivityService());
        activityMap.put(ActivityType.PURCHASE, new PurchaseActivityService());
        activityMap.put(ActivityType.RETURN, new ReturnActivityService());
        activityMap.put(ActivityType.SUPPLY, new SupplyActivityService());
        List<String> text = new ReaderServiceImpl().readFromFile(INPUT_FILE_PATH);
        if (new ValidatorServiceImpl().isValid(text)) {
            List<Fruit> fruits = new FruitStoreServiceImpl().changeBalanceFruit(text, activityMap,
                    storageDao);
            String report = new CreateReportServiceImpl().createReport(fruits);
            new WriterServiceImpl().writeData(OUTPUT_FILE_PATH, report);
        }
    }
}
