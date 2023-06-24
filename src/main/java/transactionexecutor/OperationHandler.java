package transactionexecutor;

import fruittransaction.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transaction);
}
