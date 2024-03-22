package core.basesyntax.service.operations;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.exeptions.UnsupportedOperationExeption;
import core.basesyntax.storage.Storage;

public class SupplyOperationHandler implements OperationHandler {
    public static final String SUPPLY_EXEPTION_MESSAGE = "There is no applicable operation!";

    @Override
    public void apply(FruitTransactionDto dto) throws UnsupportedOperationExeption {
        if (!isApplicable(dto)) {
            throw new UnsupportedOperationExeption(SUPPLY_EXEPTION_MESSAGE);
        }
        Integer oldValue = Storage.fruits.get(new Fruit(dto.fruitName()));
        Integer newValue = oldValue + dto.quantity();
        Storage.fruits.put(new Fruit(dto.fruitName()), newValue);
    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return "s".equals(dto.operationType());
    }
}
