package core.basesyntax.strategy;

import java.util.List;
import core.basesyntax.model.FruitTransaction;

public interface TransactionHandler {

    void parse(List<FruitTransaction> transactionList);
}
