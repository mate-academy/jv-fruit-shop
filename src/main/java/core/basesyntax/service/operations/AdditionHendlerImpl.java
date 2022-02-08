package core.basesyntax.service.operations;

import core.basesyntax.model.Storage;
import core.basesyntax.model.TransactionDto;

public class AdditionHendlerImpl implements OperationHendler {

    @Override
    public void apply(TransactionDto fruitRecord) {
        String fruitName = fruitRecord.getFruit();
        int curAmount = Storage.FRUIT_COUNT.get(fruitName) == null
                ? 0 : Storage.FRUIT_COUNT.get(fruitName);
        int newAmount = curAmount + fruitRecord.getAmount();
        Storage.FRUIT_COUNT.put(fruitName, newAmount);
    }
}
