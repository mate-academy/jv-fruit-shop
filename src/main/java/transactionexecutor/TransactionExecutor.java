package transactionexecutor;

import fruittransaction.FruitTransaction;
import java.util.List;

public interface TransactionExecutor {
    void execute(List<FruitTransaction> transactions);
}
