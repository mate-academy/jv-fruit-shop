package service.transaction;

import java.util.List;
import model.Transaction;

public interface TransactionExecutor {
    void execute(List<Transaction> transactions);
}
