package service;

import java.util.List;
import model.FruitTransaction;

public interface TransactionHandlerService {
    void transactionHandle(List<FruitTransaction> transactions);
}
