package service.process;

import java.util.List;
import model.FruitTransaction;

public interface FruitTransactionService {
    void processTransactions(List<FruitTransaction> fruitTransactions);
}
