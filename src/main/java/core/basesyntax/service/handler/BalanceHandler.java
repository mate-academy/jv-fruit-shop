package core.basesyntax.service.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.inter.Operation;

public class BalanceHandler implements Operation {

    @Override
    public void apply(FruitOperation operation) {
        Storage.fruitsQuantity.put(operation.getFruit(), operation.getQuantity());
    }
}
