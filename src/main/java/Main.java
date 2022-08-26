import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.ParcerService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.StoreService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriteServiceImpl;
import core.basesyntax.service.impl.ParcerServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.StoreServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operations.BalanceOperation;
import core.basesyntax.strategy.operations.DailyOperationHandler;
import core.basesyntax.strategy.operations.PurchaseOperation;
import core.basesyntax.strategy.operations.ReturnOperation;
import core.basesyntax.strategy.operations.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_FROM_NAME
            = "src/main/resources/morningInfo.csv";
    private static final String FILE_TO_NAME
            = "src/main/resources/dailyReport.csv";

    public static void main(String[] args) {
        // create and fill the strategy map
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, DailyOperationHandler> operationHandlerMap
                = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperation(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperation(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperation(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperation(fruitDao));

        //read data from csv file
        CsvFileReaderService csvFileReaderService = new CsvFileReaderServiceImpl();
        List<String> sourceData = csvFileReaderService.readFromFile(FILE_FROM_NAME);

        //parse transactions from strings with data
        ParcerService parserService = new ParcerServiceImpl();
        List<FruitTransaction> fruitTransactions = parserService.parseTransactions(sourceData);

        //process this data
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        StoreService storeService = new StoreServiceImpl(fruitDao, operationStrategy);
        List<Fruit> fruitsInStock = storeService.processTransaction(fruitTransactions);

        //generate a report based on processed data
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport(fruitsInStock);

        //write report to new csv file
        CsvFileWriterService csvFileWriterService = new CsvFileWriteServiceImpl();
        csvFileWriterService.writeReportToFile(report, FILE_TO_NAME);
    }
}
