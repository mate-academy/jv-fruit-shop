package service;

import java.util.List;
import model.FruitTransaction;

public interface TransactionConverter {
    List<FruitTransaction> convertToTransactionList(List<String[]> dataFromFile);
}

