package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ReportsServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_FILE = "src/main/resources/database.csv";
    public static final String OUTPUT_FILE = "src/main/resources/result.csv";

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        TransactionStrategy transactionStrategy = new TransactionStrategy(operationHandlers);
        FruitShopService shopService = new FruitShopServiceImpl(transactionStrategy);
        ReportService reportService = new ReportsServiceImpl();
        TransactionParser transactionParser = new TransactionParserImpl();
        List<String> dateFromFile = fileService.readFromFile(INPUT_FILE);
        List<FruitTransaction> fruitTransactions = transactionParser.parseInputDate(dateFromFile);
        shopService.process(fruitTransactions);
        String report = reportService.createReport(Storage.fruits);
        fileService.writeToFile(OUTPUT_FILE, report);
    }
}
