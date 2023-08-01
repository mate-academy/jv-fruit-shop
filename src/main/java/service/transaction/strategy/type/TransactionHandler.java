package service.transaction.strategy.type;

import java.util.Map;
import model.Transaction;

public interface TransactionHandler {
    void perform(Map<String, Integer> stock, Transaction transaction);
}
