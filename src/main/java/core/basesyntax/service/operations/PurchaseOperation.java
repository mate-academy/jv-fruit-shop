package core.basesyntax.service.operations;

import core.basesyntax.service.FruitTransaction;
import java.util.Map;
import java.util.NoSuchElementException;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void run(FruitTransaction fruitTransaction, Map<String, Integer> fruitRepository) {
        if (fruitRepository.get(fruitTransaction.getFruit()) == null) {
            throw new NoSuchElementException();
        }
        fruitRepository.replace(fruitTransaction.getFruit(),
                fruitRepository.get(fruitTransaction.getFruit()) - fruitTransaction.getQuantity());
    }
}
