package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handler.BalanceOperationHandler;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.PurchaseOperationHandler;
import core.basesyntax.strategy.handler.ReturnOperationHandler;
import core.basesyntax.strategy.handler.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String DATA_PATH = "src/main/resources/data.csv";
    private static final String REPORT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();

        Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(storageDao));
        handlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(storageDao));
        handlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(storageDao));
        handlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(storageDao));

        OperationStrategy operationStrategy = new OperationStrategyImpl(handlerMap);

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> data = fileReaderService.readFromFile(DATA_PATH);

        FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl();
        List<FruitTransaction> transactions = fruitTransactionParser.parse(data);

        transactions.forEach(tx ->
                operationStrategy.getHandlerByOperation(tx.getOperation()).execute(tx));

        ReportService reportService = new ReportServiceImpl(storageDao);
        String report = reportService.createReport();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(report, REPORT_PATH);
    }
}
