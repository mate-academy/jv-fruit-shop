package core.basesyntax;

import core.basesyntax.dao.DataConverter;
import core.basesyntax.dao.DataConverterImpl;
import core.basesyntax.models.Fruit;
import core.basesyntax.models.activities.ActivityHandler;
import core.basesyntax.models.activities.BalanceActivityHandler;
import core.basesyntax.models.activities.PurchaseActivityHandler;
import core.basesyntax.models.activities.ReturnActivityHandler;
import core.basesyntax.models.activities.SupplyActivityHandler;
import core.basesyntax.services.ShopService;
import core.basesyntax.services.ShopServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    // HINT: In the `public static void main(String[] args)`
    // it is better to create instances of your classes,
    // and call their methods, but do not write any business logic in the `main` method!

    private static final String PATH_REPORT_TO_READ = "src/main/resources/reportToRead.csv";
    private static final String PATH_FINAL_REPORT = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {

        List<String> productsInString = FileReaderSvc
                .readFile(PATH_REPORT_TO_READ);

        Map<Fruit.TypeOfActivity, ActivityHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put(Fruit.TypeOfActivity.BALANCE, new BalanceActivityHandler());
        activityHandlerMap.put(Fruit.TypeOfActivity.SUPPLY, new SupplyActivityHandler());
        activityHandlerMap.put(Fruit.TypeOfActivity.PURCHASE, new PurchaseActivityHandler());
        activityHandlerMap.put(Fruit.TypeOfActivity.RETURN, new ReturnActivityHandler());
        ActivityStrategy activityStrategy = new ActivityStrategyImpl(activityHandlerMap);

        ShopService shopService = new ShopServiceImpl(activityStrategy);
        DataConverter dataConverter = new DataConverterImpl();

        List<Fruit> fruits = dataConverter.convertToTransaction(productsInString);
        shopService.process(fruits);

        String report = shopService.getReport();

        FileWriterSvc.write(PATH_FINAL_REPORT, report);

    }
}
