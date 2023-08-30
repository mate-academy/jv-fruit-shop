package service;

import java.util.List;
import model.FruitTransaction;

public interface TransactionParse {
    List<FruitTransaction> transactionParse(List<String> data);
}
