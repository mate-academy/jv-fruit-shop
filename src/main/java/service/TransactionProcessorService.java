package service;

import model.FruitTransaction;

import java.util.List;

public interface TransactionProcessorService {

    void processTransaction(List<FruitTransaction> listOfTransactions);
}
