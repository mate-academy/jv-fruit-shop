package service.process;

import java.util.List;
import model.FruitTransaction;

public interface ProcessTransactionsService {
    void processTransactions(List<FruitTransaction> fruitTransactions);
}
