package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class ReturnOperation implements OperationHandler {

    @Override
    public void getOperation(List<FruitTransaction> transactions) {
        List<FruitTransaction> transactionsSelected = transactions.stream()
                .filter(a -> a.getOperation() == FruitTransaction.Operation.RETURN)
                .toList();
        for (FruitTransaction fruitTransaction : transactionsSelected) {
            int newValue =
                    Storage.fruits.get(fruitTransaction.getFruit())
                            - fruitTransaction.getQuantity();
            Storage.fruits.put(fruitTransaction.getFruit(), newValue);
        }
    }
}
