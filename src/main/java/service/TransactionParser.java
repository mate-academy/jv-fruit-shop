package service;

import java.util.List;
import model.FruitTransaction;

public interface TransactionParser {
    List<FruitTransaction> parseData(List<String> fruitOperations);
}
