package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReaderFromFile;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionExecutor;
import core.basesyntax.service.WriterToFile;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderFromFileImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionExecutorImpl;
import core.basesyntax.service.impl.WriterToFileImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FROM_FILE_NAME = "src/main/resources/testFile.csv";
    private static final String TO_FILE_NAME = "src/main/resources/resultTestFile.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);
        ReaderFromFile readerFromCsvFile = new ReaderFromFileImpl();
        WriterToFile writerToCsvFile = new WriterToFileImpl();
        TransactionExecutor transactionExecutor = new TransactionExecutorImpl(operationStrategy);
        ReportService reportService = new ReportServiceImpl();
        Parser parser = new ParserImpl();

        List<String> infoData = readerFromCsvFile.readFromFile(FROM_FILE_NAME);
        List<FruitTransaction> transactions = parser.parse(infoData);
        transactionExecutor.execute(transactions);
        String reportData = reportService.generateReport(Storage.fruitData);
        writerToCsvFile.writeToFile(TO_FILE_NAME, reportData);
    }
}
