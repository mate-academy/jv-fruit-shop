package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.dao.impl.FruitTransactionDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessDataService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.impl.ProcessDataServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME =
            "src/main/resources/input_db.csv";
    private static final String OUTPUT_FILE_NAME =
            "src/main/resources/output_db.csv";
    private final ReaderService readerService = new ReaderServiceImpl();
    private final WriteService writeService = new WriteServiceImpl();
    private final FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();
    private final FruitDao fruitDao = new FruitDaoImpl();
    private final OperationStrategy operationStrategies =
            new OperationStrategyImpl(createMapOfOperationStrategies());
    private final ProcessDataService processDataService =
            new ProcessDataServiceImpl(operationStrategies);
    private final ReportService reportService = new ReportServiceImpl(fruitDao);

    public static void main(String[] args) {
        Main main = new Main();
        // read data from file
        List<FruitTransaction> fruitTransactions = main.readDataFromFile();
        // add fruit transactions to DB
        main.addTransactionsToDb(fruitTransactions);
        // print fruit transactions
        main.print(fruitTransactions);
        // process fruit transactions
        main.processData(fruitTransactions);
        // get processed data (fruits) from DB
        List<Fruit> fruits = main.getFruitsFromDb();
        // print fruits
        main.print(fruits);
        // create report
        String report = main.createReport(fruits);
        // print report
        System.out.println("Report:\n" + report);
        // write report to file
        main.writeDataToFile(report);
    }

    private Map<FruitTransaction.Operation, OperationHandler> createMapOfOperationStrategies() {
        Map<FruitTransaction.Operation, OperationHandler> operationServiceMap = new HashMap<>();
        operationServiceMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(fruitDao));
        operationServiceMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(fruitDao));
        operationServiceMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(fruitDao));
        operationServiceMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(fruitDao, fruitTransactionDao));
        return operationServiceMap;
    }

    public <T> void print(List<T> list) { // TODO: correct if necessary
        list.forEach(System.out::println);
    }

    public List<FruitTransaction> readDataFromFile() {
        return readerService.readDataFromFile(INPUT_FILE_NAME);
    }

    public void addTransactionsToDb(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            fruitTransactionDao.add(fruitTransaction);
        }
    }

    public void processData(List<FruitTransaction> fruitTransactions) {
        processDataService.processData(fruitTransactions);
    }

    private String createReport(List<Fruit> fruits) {
        return reportService.createReport(fruits);
    }

    private void writeDataToFile(String data) {
        writeService.writeDataToFile(OUTPUT_FILE_NAME, data);
    }

    public List<Fruit> getFruitsFromDb() {
        return fruitDao.getAll();
    }
}
