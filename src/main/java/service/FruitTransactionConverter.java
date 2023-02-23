package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitTransactionConverter {
    List<FruitTransaction> convertToFruitTransaction(List<String> inputData);
}
