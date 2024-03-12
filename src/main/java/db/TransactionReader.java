package db;

import java.util.List;
import model.FruitTransaction;

public interface TransactionReader {
    List<FruitTransaction> readTransactionsFromFile(String fileName);
}
