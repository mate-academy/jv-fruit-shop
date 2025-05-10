package core.basesyntax.service;

import core.basesyntax.transaction.FruitTransaction;
import java.util.List;

public interface ShopService {

    void processTransactions(List<FruitTransaction> transactionList);

}
