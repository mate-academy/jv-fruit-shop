package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitService {
    void processTransactions(List<FruitTransaction> transactions);
}
