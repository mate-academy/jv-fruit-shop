package core.basesyntax;

import core.basesyntax.dao.DataConverter;
import core.basesyntax.dao.DataConverterImpl;
import core.basesyntax.models.Product;
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
public class HelloWorld {
    // HINT: In the `public static void main(String[] args)`
    // it is better to create instances of your classes,
    // and call their methods, but do not write any business logic in the `main` method!
    public static void main(String[] args) {

        List<String> productsInString = FileReaderSvc
                .readFile("src/main/java/core/basesyntax/db/reportToRead.csv");

        DataConverter dataConverter = new DataConverterImpl();

        Map<Product.TypeOfActivity, ActivityHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put(Product.TypeOfActivity.BALANCE, new BalanceActivityHandler());
        activityHandlerMap.put(Product.TypeOfActivity.SUPPLY, new SupplyActivityHandler());
        activityHandlerMap.put(Product.TypeOfActivity.PURCHASE, new PurchaseActivityHandler());
        activityHandlerMap.put(Product.TypeOfActivity.RETURN, new ReturnActivityHandler());
        ActivityStrategy activityStrategy = new ActivityStrategyImpl(activityHandlerMap);

        ShopService shopService = new ShopServiceImpl(activityStrategy);

        List<Product> products = dataConverter.convertToTransaction(productsInString);
        shopService.process(products);

        String report = shopService.getReport();

        FileWriterSvc.write("src/main/java/core/basesyntax/db/finalReport.csv", report);

    }
}
