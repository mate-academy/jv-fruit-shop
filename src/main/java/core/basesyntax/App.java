package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.FruitTransactionServiceImpl;
import core.basesyntax.service.StrategyImpl;
import core.basesyntax.service.operation.BalanceOperationHandlerImpl;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandlerImpl;
import core.basesyntax.service.operation.ReturnOperationHandlerImpl;
import core.basesyntax.service.operation.SupplyOperationHandlerImpl;
import core.basesyntax.service.reader.ReaderServiceICsvImpl;
import core.basesyntax.service.writer.WriterServiceCsvImpl;
import java.util.HashMap;
import java.util.Map;

public class App {
    private static final String FILE_NAME_INPUT = "input.csv";
    private static final String FILE_NAME_OUTPUT = "result.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandlerImpl());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandlerImpl());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandlerImpl());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandlerImpl());

        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl(new ReaderServiceICsvImpl(),
                new WriterServiceCsvImpl(), new StrategyImpl(operationHandlerMap));
        fruitTransactionService.transaction(FILE_NAME_INPUT, FILE_NAME_OUTPUT);
    }
}
