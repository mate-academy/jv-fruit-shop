package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitTransactionParser {
    List<FruitTransaction> toTransactions(String data);
}
