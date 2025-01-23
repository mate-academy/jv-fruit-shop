package core.basesyntax;

import core.basesyntax.dao.DataConverter;
import core.basesyntax.dao.DataConverterImpl;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.models.Fruit;
import core.basesyntax.models.activities.ActivityHandler;
import core.basesyntax.models.activities.BalanceActivityHandler;
import core.basesyntax.models.activities.PurchaseActivityHandler;
import core.basesyntax.models.activities.ReturnActivityHandler;
import core.basesyntax.models.activities.SupplyActivityHandler;
import core.basesyntax.services.DataProcessorImpl;
import core.basesyntax.services.ReportGeneratorImpl;
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

        FileReaderCsv fileReaderCsv = new FileReaderCsvImpl();
        List<String> productsInString = fileReaderCsv.readFile(PATH_REPORT_TO_READ);

        DataConverter dataConverter = new DataConverterImpl();

        List<Fruit> fruits = dataConverter.convertToTransaction(productsInString);
        Storage.fruitStorage.addAll(fruits);

        Map<Fruit.TypeOfActivity, ActivityHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put(Fruit.TypeOfActivity.BALANCE, new BalanceActivityHandler());
        activityHandlerMap.put(Fruit.TypeOfActivity.SUPPLY, new SupplyActivityHandler());
        activityHandlerMap.put(Fruit.TypeOfActivity.PURCHASE, new PurchaseActivityHandler());
        activityHandlerMap.put(Fruit.TypeOfActivity.RETURN, new ReturnActivityHandler());
        ActivityStrategy activityStrategy = new ActivityStrategyImpl(activityHandlerMap);

        FruitDao fruitDao = new FruitDaoImpl();
        DataProcessorImpl dataProcessorImpl = new DataProcessorImpl(activityStrategy, fruitDao);

        ReportGeneratorImpl reportGeneratorImpl = new ReportGeneratorImpl();

        ShopService shopService = new ShopServiceImpl(dataProcessorImpl, reportGeneratorImpl);

        String report = shopService.getReport();

        FileWriterCsv fileWriterCsv = new FileWriterCsvImpl();
        fileWriterCsv.write(PATH_FINAL_REPORT, report);

    }
}
