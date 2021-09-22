package core.basesyntax.service.operationstrategy;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.ValidationException;
import core.basesyntax.model.FruitOperationDto;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handler(FruitOperationDto dto) throws ValidationException {
        Integer intermediateResult = Storage.fruitStorage.get(dto.getFruitName());
        intermediateResult -= dto.getQuantity();
        if (intermediateResult < 0) {
            throw new ValidationException("Error! Buying more than is available. In stock: "
                    + Storage.fruitStorage.get(dto.getFruitName()
                    + "You want to buy: " + dto.getQuantity()));
        }
        Storage.fruitStorage.put(dto.getFruitName(), intermediateResult);
    }
}
