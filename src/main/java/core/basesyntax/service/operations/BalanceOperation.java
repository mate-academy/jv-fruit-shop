package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class BalanceOperation implements OperationHandler {

    @Override
    public void getOperation(List<FruitTransaction> transactions) {
        List<FruitTransaction> transactionsSelected = transactions.stream()
                .filter(a -> a.getOperation() == FruitTransaction.Operation.BALANCE)
                .toList();
        for (FruitTransaction fruitTransaction : transactionsSelected) {
            Storage.fruits.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
