package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE
            = "src/main/java/core/basesyntax/resources/input_file.csv";
    private static final String REPORT_FILE
            = "src/main/java/core/basesyntax/resources/report_file.csv";

    public static void main(String[] args) {
        List<String> linesFromFile = new ReaderServiceImpl().readFromFile(INPUT_FILE);
        final List<FruitTransaction> fruitTransactions =
                new TransactionServiceImpl().parseTransaction(linesFromFile);
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        OperationStrategy strategy = new OperationStrategy(operationHandlerMap);
        FruitService fruitService = new FruitServiceImpl();
        fruitService.getOperationByFruit(fruitTransactions, strategy);
        new WriterServiceImpl()
                .writeToFile(REPORT_FILE, new ReportServiceImpl().writeReport());
    }
}
