package service;

import java.util.List;
import model.FruitTransaction;

public interface ToFruitTransactionService {
    List<FruitTransaction> getListOfFruitTransactions(List<String> fileInfo);
}
