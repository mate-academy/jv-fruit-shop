package service;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public interface TransactionProcessorService {
    Map<String, Integer> processTransaction(List<FruitTransaction> transactions);
}
