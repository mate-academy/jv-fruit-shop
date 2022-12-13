package service;

import model.FruitTransaction;
import java.util.List;

public interface TransactionParser {
    List<FruitTransaction> parseAll(List<String> stringList);
}
