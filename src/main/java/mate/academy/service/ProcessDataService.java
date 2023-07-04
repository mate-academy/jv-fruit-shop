package mate.academy.service;//*

import java.util.List;
import mate.academy.model.FruitTransaction;
import mate.academy.strategy.TransactionStrategy;

public interface ProcessDataService {
    void processTransactions(List<FruitTransaction> transactions
            , TransactionStrategy transactionStrategy);
}
