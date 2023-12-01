package strategy;

import model.Transaction;
import service.transaction.HandlerTransaction;

public interface StrategyTransaction {
    HandlerTransaction get(Transaction transaction);
}
