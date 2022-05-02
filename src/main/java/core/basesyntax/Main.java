package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.OperationServiceImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.service.strategy.BalanceOperationHandler;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.PurchaseOperationHandler;
import core.basesyntax.service.strategy.ReturnOperationHandler;
import core.basesyntax.service.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String DATA_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        ReaderService readerService = new ReaderServiceImpl();
        ParserService parserService = new ParserServiceImpl();

        Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(storageDao));
        handlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(storageDao));
        handlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(storageDao));
        handlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(storageDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlerMap);

        OperationService operationService = new OperationServiceImpl(operationStrategy);
        ReportService reportService = new ReportServiceImpl(storageDao);
        WriterService writerService = new WriterServiceImpl();

        List<String> data = readerService.readFromFile(DATA_PATH);
        List<FruitTransaction> transactions = parserService.parse(data);
        operationService.executeTransactions(transactions);
        String report = reportService.createReport();
        writerService.writeToFile(OUTPUT_PATH, report);
    }
}
