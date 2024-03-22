package core.basesyntax.service.operations;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.exeptions.NegativeNumberExeption;
import core.basesyntax.service.exeptions.UnsupportedOperationExeption;
import core.basesyntax.storage.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    public static final String PURCHASE_EXEPTION_MESSAGE = "There is no applicable operation!";
    public static final String NEGATIVE_OPERATION_EXEPTION = "Purchase not allowed!";

    @Override
    public void apply(FruitTransactionDto dto) {
        if (!isApplicable(dto)) {
            throw new UnsupportedOperationExeption(PURCHASE_EXEPTION_MESSAGE);
        }
        Integer oldValue = Storage.fruits.get(new Fruit(dto.fruitName()));
        if (oldValue - dto.quantity() < 0) {
            throw new NegativeNumberExeption(NEGATIVE_OPERATION_EXEPTION);
        }
        Integer newValue = oldValue - dto.quantity();
        Storage.fruits.put(new Fruit(dto.fruitName()), newValue);
    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return "p".equals(dto.operationType());
    }
}
