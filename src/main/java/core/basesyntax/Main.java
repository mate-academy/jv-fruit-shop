package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.db.impl.FruitStorageImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.impl.BalanceOperationHandler;
import core.basesyntax.operation.impl.PurchaseOperationHandler;
import core.basesyntax.operation.impl.ReturnOperationHandler;
import core.basesyntax.operation.impl.SupplyOperationHandler;
import core.basesyntax.service.impl.CsvReaderImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String input = "src/main/resources/input.csv";
    private static final String output = "src/main/resources/output.csv";

    public static void main(String[] args) {
        FruitStorage fruitStorage = new FruitStorageImpl();
        new TransactionServiceImpl(createOperationHandlerMap(fruitStorage))
                .executeTransactions(new CsvReaderImpl().readFromFile(input));
        new WriteServiceImpl().writeToFile(output,
                new ReportServiceImpl().generateReport(fruitStorage.getAll()));
    }

    private static Map<Operation, OperationHandler> createOperationHandlerMap(
            FruitStorage fruitStorage) {
        Map<Operation, OperationHandler> map = new HashMap<>();
        map.put(Operation.BALANCE, new BalanceOperationHandler(fruitStorage));
        map.put(Operation.PURCHASE, new PurchaseOperationHandler(fruitStorage));
        map.put(Operation.RETURN, new SupplyOperationHandler(fruitStorage));
        map.put(Operation.SUPPLY, new ReturnOperationHandler(fruitStorage));
        return map;
    }
}
