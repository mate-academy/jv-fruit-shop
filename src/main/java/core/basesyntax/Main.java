package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReadServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHendler;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/java/core/basesyntax/files/input_file.csv";
    private static final String REPORT_FILE = "src/main/java/core/basesyntax/files/report_file.csv";

    public static void main(String[] args) {
        List<String> dataFromFile = new ReadServiceImpl().readFromFile(INPUT_FILE);
        final List<FruitTransaction> fruitTransactionList =
                new TransactionImpl().parseTransaction(dataFromFile);
        Map<FruitTransaction.Operation, OperationHendler> operationHandlerMap = new HashMap<>();
        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            OperationHendler handler = strategy.get(fruitTransaction.getOperation());
            handler.operateTransaction(fruitTransaction);
        }
        new WriteServiceImpl().writeToFile(REPORT_FILE, new ReportServiceImpl().writeReport());
    }
}
