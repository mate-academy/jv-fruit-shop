package service;

import java.util.List;
import model.FruitTransaction;

public interface TransactionMapper {
    List<FruitTransaction> map(List<String> fruitTransactionsList);
}
