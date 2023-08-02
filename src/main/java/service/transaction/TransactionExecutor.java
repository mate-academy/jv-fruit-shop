package service.transaction;

import java.util.List;
import model.FruitTransaction;

public interface TransactionExecutor {
    void execute(List<FruitTransaction> fruitTransactions);
}
