package service;

import java.util.List;
import model.FruitTransaction;

public interface StrategyProcessor {

    void processTransactionStrategies(List<FruitTransaction> transactionList);
}
