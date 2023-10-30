package service;

import java.util.List;
import model.FruitTransaction;

public interface ReportMaking {
    void processFruitTransactions(List<FruitTransaction> fruitTransactions);
}
