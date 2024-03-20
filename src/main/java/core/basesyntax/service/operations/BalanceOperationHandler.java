package core.basesyntax.service.operations;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.exeptions.UnsupportedOperationExeption;
import core.basesyntax.storage.Storage;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void apply(FruitTransactionDto dto) {
        if (!isApplicable(dto)) {
            throw new UnsupportedOperationExeption("There is no applicable operation!");
        }
        Storage.fruits.put(new Fruit(dto.fruitName()), dto.quantity());
    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return "b".equals(dto.operationType());
    }
}
