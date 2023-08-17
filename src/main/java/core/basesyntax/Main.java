package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME =
            "src/main/resources/input_db.csv";
    private static final String OUTPUT_FILE_NAME =
            "src/main/resources/output_db.csv";
    private static final ReaderService readerService = new ReaderServiceImpl();
    private static final WriteService writeService = new WriteServiceImpl();
    private static final ParseService parseService = new ParseServiceImpl();
    private static final FruitDao fruitDao = new FruitDaoImpl();
    private static final OperationStrategy operationStrategies =
            new OperationStrategyImpl(createMapOfOperationStrategies());
    private static final TransactionService processDataService =
            new TransactionServiceImpl(operationStrategies);
    private static final ReportService reportService = new ReportServiceImpl(fruitDao);

    public static void main(String[] args) {
        // read data from file
        List<String> inputData = readerService.readDataFromFile(INPUT_FILE_NAME);
        // parse fruit transactions
        List<FruitTransaction> fruitTransactions = parseService.parseTransactions(inputData);
        // print fruit transactions
        fruitTransactions.forEach(System.out::println);
        // process fruit transactions
        processDataService.processTransactions(fruitTransactions);
        // get processed data (fruits) from DB
        Map<String, BigDecimal> fruits = fruitDao.getAll();
        // print fruits
        fruits.entrySet().forEach(System.out::println);
        // create report
        String report = reportService.createReport();
        // print report
        System.out.println("Report:\n" + report);
        // write report to file
        writeService.writeDataToFile(OUTPUT_FILE_NAME, report);
    }

    private static Map<FruitTransaction.Operation,
            OperationHandler> createMapOfOperationStrategies() {
        Map<FruitTransaction.Operation, OperationHandler> operationServiceMap = new HashMap<>();
        operationServiceMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(fruitDao));
        operationServiceMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(fruitDao));
        operationServiceMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(fruitDao));
        operationServiceMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(fruitDao));
        return operationServiceMap;
    }
}
