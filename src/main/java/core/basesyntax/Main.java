package core.basesyntax;

import core.basesyntax.dao.FruitShopService;
import core.basesyntax.dao.FruitShopServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalanceOperation;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseOperation;
import core.basesyntax.operation.ReturnOperation;
import core.basesyntax.operation.SupplyOperation;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileReaderServiceImpl;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FileWriterServiceImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionParserImpl;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.TransactionServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_INPUT_NAME = "src/main/resources/input.csv";
    private static final String FILE_REPORT_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        FruitShopService fruitShopService = new FruitShopServiceImpl();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperation(fruitShopService));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperation(fruitShopService));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperation(fruitShopService));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperation(fruitShopService));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FileReaderService readerService = new FileReaderServiceImpl();
        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> fruitTransactions =
                transactionParser.parseFruitTransaction(readerService.read(FILE_INPUT_NAME));
        TransactionService transactionService = new TransactionServiceImpl(operationStrategy);
        transactionService.proceedTransactions(fruitTransactions);
        ReportService reportService = new ReportServiceImpl();
        FileWriterService writerService = new FileWriterServiceImpl();
        writerService.write(reportService.createReport(), FILE_REPORT_NAME);
    }
}
