package core.basesyntax.service.operations;

import core.basesyntax.model.Storage;
import core.basesyntax.model.TransactionDto;
import java.util.Map;

public class SubstractionHendlerImpl implements OperationHendler {
    private static final Map<String, Integer> FRUIT_COUNT = Storage.FRUIT_COUNT;

    @Override
    public void apply(TransactionDto fruitRecord) {
        String fruitName = fruitRecord.getFruit();
        int curAmount = FRUIT_COUNT.get(fruitName) == null ? 0 : FRUIT_COUNT.get(fruitName);
        int newAmount = curAmount - fruitRecord.getAmount();
        FRUIT_COUNT.put(fruitName, newAmount);
    }
}
