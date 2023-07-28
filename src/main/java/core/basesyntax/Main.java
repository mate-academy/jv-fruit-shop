package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitTransactionParserService;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.FruitTransactionsReportService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionParserServiceImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.FruitTransactionsReportServiceImpl;
import core.basesyntax.service.transactions.BalanceOperationHandler;
import core.basesyntax.service.transactions.OperationHandler;
import core.basesyntax.service.transactions.PurchaseOperationHandler;
import core.basesyntax.service.transactions.ReturnOperationHandler;
import core.basesyntax.service.transactions.SupplyOperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final String TRANSACTIONS_PATH = "src" + File.separator + "transactions.csv";
    private static final String REPORT_PATH = "src" + File.separator + "report.csv";
    private static Map<FruitTransaction.Operation, OperationHandler> strategyMap = new HashMap<>();

    public static void main(String[] args) {
        fillMap();
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> strings = fileReaderService.readFromFile(TRANSACTIONS_PATH);

        FruitTransactionParserService parser = new FruitTransactionParserServiceImpl();
        List<FruitTransaction> fruitTransactions = parser.stringToFruitTransactions(strings);

        OperationStrategy operationStrategy = new OperationStrategyImpl(strategyMap);
        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl(operationStrategy);
        fruitTransactionService.addOrUpdate(fruitTransactions);

        FruitTransactionsReportService fruitTransactionsReportService
                = new FruitTransactionsReportServiceImpl();
        String report = fruitTransactionsReportService.createReport();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(REPORT_PATH,report);
    }

    private static void fillMap() {
        strategyMap.put(FruitTransaction.Operation.BALANCE,new BalanceOperationHandler());
        strategyMap.put(FruitTransaction.Operation.PURCHASE,new PurchaseOperationHandler());
        strategyMap.put(FruitTransaction.Operation.SUPPLY,new SupplyOperationHandler());
        strategyMap.put(FruitTransaction.Operation.RETURN,new ReturnOperationHandler());
    }
}
