package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.DataServiceStrategy;
import java.util.List;

public class ProcessTransactions {
    private DataServiceStrategy dataServiceStrategy;

    public ProcessTransactions(DataServiceStrategy dataServiceStrategy) {
        this.dataServiceStrategy = dataServiceStrategy;
    }

    void processFruitTransactionList(List<FruitTransaction> fruitTransactionList) {
        fruitTransactionList.stream()
                .forEach(f -> dataServiceStrategy.get(f.getOperation()).processTransaction(f));
    }
}
