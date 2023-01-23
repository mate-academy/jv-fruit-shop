package core;

import core.db.Storage;
import core.model.FruitTransaction;
import core.service.DataParserService;
import core.service.ReaderService;
import core.service.ReportSevice;
import core.service.TransactionHandler;
import core.service.WriterService;
import core.service.impl.DataParserServiceImpl;
import core.service.impl.ReaderServiceImpl;
import core.service.impl.ReportSeviceImpl;
import core.service.impl.TransactionHandlerImpl;
import core.service.impl.WriterServiceImpl;
import core.strategy.BalanceOperationHandler;
import core.strategy.OperationHandler;
import core.strategy.OperationStrategyImpl;
import core.strategy.PurchaseOperationHandler;
import core.strategy.ReturnOperationHandler;
import core.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap = new HashMap<>();
    private static final String INPUT_FILE = "src/main/java/resources/file.csv";
    private static final String REPORT_FILE = "src/main/java/resources/report.csv";

    public static void main(String[] args) {
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromFile = readerService.readFromFile(INPUT_FILE);
        DataParserService parser = new DataParserServiceImpl();
        List<FruitTransaction> transactions = parser.parseList(dataFromFile);
        OperationStrategyImpl operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        TransactionHandler transactionHandler = new TransactionHandlerImpl(operationStrategy);
        transactionHandler.handle(transactions);
        ReportSevice reportSevice = new ReportSeviceImpl();
        List<String> report = reportSevice.reportGenerator(Storage.fruits);
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(report, REPORT_FILE);
    }
}
