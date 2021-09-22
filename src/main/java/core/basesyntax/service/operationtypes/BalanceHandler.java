package core.basesyntax.service.operationtypes;

import core.basesyntax.db.Storage;

public class BalanceHandler implements OperationTypeHandler {

    @Override
    public void apply(String fruitName, int amount) {
        Storage.fruits.put(fruitName, amount);
    }
}
