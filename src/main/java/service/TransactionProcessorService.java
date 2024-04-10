package service;

import model.FruitTransaction;

import java.util.List;
import java.util.Map;

public interface TransactionProcessorService {
    Map<String, Integer> processTransaction(List<FruitTransaction> transactions);
}
