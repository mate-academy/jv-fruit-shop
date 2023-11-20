package dao;

import java.util.List;
import model.FruitTransaction;

public interface ReadFile {
    List<FruitTransaction> readTransactionsFromFile(String fileName);
}
