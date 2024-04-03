package service;

import model.FruitTransaction;
import strategy.FruitStrategy;

import java.util.List;
import java.util.Map;

public interface TransactionProcessorService {

    void processTransaction(List<FruitTransaction> listOfTransactions);
}
