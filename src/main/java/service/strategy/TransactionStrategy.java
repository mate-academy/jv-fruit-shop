package service.strategy;

import java.util.List;
import model.Transaction;

public interface TransactionStrategy {
    void execute(List<Transaction> transactions);
}
