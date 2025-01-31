package service;

import java.util.List;
import model.FruitTransaction;

public interface Reader {

    List<FruitTransaction> readTransactionsFromCsv(String fileName);
}
