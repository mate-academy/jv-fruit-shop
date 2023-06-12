package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitTransactionParser {
    List<FruitTransaction> parseFruitTransaction(List<String> storeActivities);
}
