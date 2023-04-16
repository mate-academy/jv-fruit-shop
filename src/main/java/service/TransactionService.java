package service;

import java.util.List;
import model.FruitTransaction;

public interface TransactionService {
    List<FruitTransaction> createTransactionsList(List<String> data);
}
