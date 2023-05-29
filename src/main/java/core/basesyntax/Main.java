package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE
            = "src/main/resources/input_file.csv";
    private static final String REPORT_FILE
            = "src/main/resources/report_file.csv";

    public static void main(String[] args) {
        final Map<String, Integer> map = Storage.getStorageMap();
        List<String> linesFromFile = new ReaderServiceImpl().readFromFile(INPUT_FILE);
        final List<FruitTransaction> fruitTransactions =
                new TransactionServiceImpl().parseTransactions(linesFromFile);
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        OperationStrategy strategy = new OperationStrategy(operationHandlerMap);
        FruitService fruitService = new FruitServiceImpl(strategy);
        fruitService.executeTransactions(fruitTransactions);
        new WriterServiceImpl()
                .writeToFile(REPORT_FILE, new ReportServiceImpl().createReport());
    }
}
