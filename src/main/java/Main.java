import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionsDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.StoreService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriteServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
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
    public static void main(String[] args) {
        // create and fill the strategy map
        Map<FruitTransaction.Operation, DailyOperationHandler> operationHandlerMap
                = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        //read data from csv file
        CsvFileReaderService csvFileReaderService = new CsvFileReaderServiceImpl();
        List<FruitTransaction> fruitTransactions = csvFileReaderService.readTransactionFromFile();

        //add all daily transactions to temporary storage StorageFruitTransaction
        FruitTransactionDao fruitTransactionDao = new FruitTransactionsDaoImpl();
        fruitTransactionDao.add(fruitTransactions);
        fruitTransactions = fruitTransactionDao.getAllTransaction();

        //create List of fruits in Storage
        FruitService fruitService = new FruitServiceImpl(new FruitDaoImpl());
        fruitService.createFruit(fruitTransactions);

        //process this data
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        StoreService storeService = new StoreServiceImpl(new FruitDaoImpl(), operationStrategy);
        List<Fruit> fruitsInStock = storeService.fruitTransaction(fruitTransactions);

        //generate a report based on processed data
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport(fruitsInStock);

        //write report to new csv file
        CsvFileWriterService csvFileWriterService = new CsvFileWriteServiceImpl();
        csvFileWriterService.writeReportToFile(report);

    }
}
