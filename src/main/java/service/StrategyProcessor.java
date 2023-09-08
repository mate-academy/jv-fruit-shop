package service;

import java.util.List;
import model.Transaction;

public interface StrategyProcessor {

    void processTransactionStrategies(List<Transaction> transactionList);
}
