package core.basesyntax;

import core.basesyntax.dao.DataConverter;
import core.basesyntax.dao.DataConverterImpl;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.models.activities.ActivityHandler;
import core.basesyntax.models.activities.BalanceActivityHandler;
import core.basesyntax.models.activities.PurchaseActivityHandler;
import core.basesyntax.models.activities.ReturnActivityHandler;
import core.basesyntax.models.activities.SupplyActivityHandler;
import core.basesyntax.services.DataProcessor;
import core.basesyntax.services.DataProcessorImpl;
import core.basesyntax.services.ReportGeneratorImpl;
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

    private static final String PATH_REPORT_TO_READ = "src/main/resources/reportToRead.csv";
    private static final String PATH_FINAL_REPORT = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {

        FileReaderCsv fileReaderCsv = new FileReaderCsvImpl();
        List<String> productsInString = fileReaderCsv.readFile(PATH_REPORT_TO_READ);

        Map<FruitTransaction.TypeOfActivity, ActivityHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put(FruitTransaction.TypeOfActivity.BALANCE,
                new BalanceActivityHandler());
        activityHandlerMap.put(FruitTransaction.TypeOfActivity.SUPPLY,
                new SupplyActivityHandler());
        activityHandlerMap.put(FruitTransaction.TypeOfActivity.PURCHASE,
                new PurchaseActivityHandler());
        activityHandlerMap.put(FruitTransaction.TypeOfActivity.RETURN,
                new ReturnActivityHandler());
        ActivityStrategy activityStrategy = new ActivityStrategyImpl(activityHandlerMap);

        // З файлу у Ліст Фруктів
        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> fruitTransactionList = dataConverter
                .convertToTransaction(productsInString);

        // Порахувати все і засунуть в сторедж
        DataProcessor dataProcessorImpl = new DataProcessorImpl(activityStrategy);
        dataProcessorImpl.process(fruitTransactionList);

        // Отримати репорт
        ReportGeneratorImpl reportGeneratorImpl = new ReportGeneratorImpl();

        String report = reportGeneratorImpl.generate();

        FileWriterCsv fileWriterCsv = new FileWriterCsvImpl();
        fileWriterCsv.write(PATH_FINAL_REPORT, report);

    }
}
