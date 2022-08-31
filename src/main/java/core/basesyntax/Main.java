package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitTransactionCollector;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionProcessingService;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitTransactionCollectorImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionProcessingServiceImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH =
            "src/main/java/core/basesyntax/resources/input.csv";
    private static final String OUTPUT_FILE_PATH =
            "src/main/java/core/basesyntax/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlersMap = new HashMap<>();
        operationHandlersMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(fruitDao));
        operationHandlersMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(fruitDao));
        operationHandlersMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(fruitDao));
        operationHandlersMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(fruitDao));

        FileReader reader = new FileReaderImpl();
        List<String> inputStrings = reader.readFromFile(INPUT_FILE_PATH);

        FruitTransactionCollector collector = new FruitTransactionCollectorImpl();
        List<FruitTransaction> fruitTransactions =
                collector.collectFruitTransactions(inputStrings);

        OperationStrategy strategy = new OperationStrategyImpl(operationHandlersMap);
        TransactionProcessingService processingService =
                new TransactionProcessingServiceImpl(strategy);
        processingService.calculate(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport(Storage.fruits);

        FileWriter writer = new FileWriterImpl();
        writer.writeToFile(report, OUTPUT_FILE_PATH);
    }
}
