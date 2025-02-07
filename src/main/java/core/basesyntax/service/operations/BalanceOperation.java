package core.basesyntax.service.operations;

import core.basesyntax.service.FruitTransaction;
import java.util.Map;

public class BalanceOperation implements OperationHandler {

    @Override
    public void run(FruitTransaction fruitTransaction, Map<String, Integer> fruitRepository) {
        fruitRepository.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
