package core.basesyntax;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.FruitTransactionServiceImpl;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import core.basesyntax.service.reader.ReaderServiceICsvImpl;
import core.basesyntax.service.writer.WriterServiceCsvImpl;
import java.util.HashMap;
import java.util.Map;

public class App {
    private static final String FILE_NAME_INPUT = "input.csv";
    private static final String FILE_NAME_OUTPUT = "result.csv";

    public static void main(String[] args) {
        FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(fruitTransactionDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(fruitTransactionDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(fruitTransactionDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(fruitTransactionDao));

        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl(new ReaderServiceICsvImpl(),
                new WriterServiceCsvImpl(), new OperationStrategyImpl(operationHandlerMap));
        fruitTransactionService.process(FILE_NAME_INPUT, FILE_NAME_OUTPUT);
    }
}
