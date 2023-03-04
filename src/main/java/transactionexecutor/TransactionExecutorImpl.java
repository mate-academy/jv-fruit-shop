package transactionexecutor;

import db.Storage;
import fruittransaction.FruitTransaction;
import java.util.List;

public class TransactionExecutorImpl implements TransactionExecutor {
    private Storage objectForStorage = new Storage();
    private final OperationSupplyImpl operationSupply = new OperationSupplyImpl();

    @Override
    public void execute(List<FruitTransaction> transactions) {
        objectForStorage.setStorage(operationSupply.startOperation(transactions));
    }
}
