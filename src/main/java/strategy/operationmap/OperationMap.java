package strategy.operationmap;

import java.util.Map;
import model.FruitTransaction;
import strategy.transactionhandlers.TransactionHandler;

public interface OperationMap {
    Map<FruitTransaction.Operation, TransactionHandler> getOperationMap();

    void addOperationToMap(FruitTransaction.Operation operation,
                           TransactionHandler handler);
}
