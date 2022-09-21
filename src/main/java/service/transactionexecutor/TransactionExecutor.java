package service.transactionexecutor;

import java.util.List;
import model.FruitTransaction;

public interface TransactionExecutor {
    void executeTransaction(List<FruitTransaction> fruitList);
}
