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
import core.basesyntax.service.impl.ValidationServiceImpl;
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
    private static final String DATA_PATH = "src/main/java/core/basesyntax/resources/data.csv";
    private static final String REPORT_PATH = "src/main/java/core/basesyntax/resources/report.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        ReaderService readerService = new ReaderServiceImpl();
        ValidationServiceImpl validationService = new ValidationServiceImpl();
        ParserService parserService = new ParserServiceImpl(validationService);

        Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        handlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        handlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        handlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        OperationStrategy operationStrat = new OperationStrategyImpl(handlerMap);

        OperationService operationService = new OperationServiceImpl(operationStrat, storageDao);
        ReportService reportService = new ReportServiceImpl(storageDao);
        WriterService writerService = new WriterServiceImpl();

        List<String> data = readerService.readFromFile(DATA_PATH);
        List<FruitTransaction> transactions = parserService.parse(data);
        operationService.executeTransactions(transactions);
        String report = reportService.makeReport();
        writerService.writeToFile(REPORT_PATH, report);
    }
}
