package service;

import java.util.List;
import java.util.Map;
import strategy.TransactionStrategy;

public interface TransactionService {
    boolean transactionToDataBase(List<String> data, Map<String, TransactionStrategy> strategy);
}
