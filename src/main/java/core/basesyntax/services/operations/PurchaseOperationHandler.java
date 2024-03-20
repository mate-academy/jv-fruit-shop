package core.basesyntax.services.operations;

import static core.basesyntax.db.StorageDao.fruitStorage;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.exceptions.FruitStorageException;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransactionDto dto) {
        if (fruitStorage.get(dto.fruitName()) == null) {
            throw new FruitStorageException("There are no " + dto.fruitName() + " in storage");
        }
        Integer amount = fruitStorage.get(dto.fruitName());
        Integer purchaseAmount = dto.quantity();
        if (amount < purchaseAmount) {
            throw new FruitStorageException("Purchase is to big");
        }
        fruitStorage.put(dto.fruitName(), amount - purchaseAmount);
    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return "p".equals(dto.operationType());
    }
}
