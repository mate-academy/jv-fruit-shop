package core.basesyntax.service.operations;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.exeptions.UnsupportedOperationExeption;
import core.basesyntax.storage.Storage;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransactionDto dto) {
        if (!isApplicable(dto)) {
            throw new UnsupportedOperationExeption("There is no applicable operation!");
        }
        Integer oldValue = Storage.fruits.get(new Fruit(dto.fruitName()));
        Integer newValue = oldValue + dto.quantity();
        Storage.fruits.put(new Fruit(dto.fruitName()), newValue);
    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return "r".equals(dto.operationType());
    }
}
