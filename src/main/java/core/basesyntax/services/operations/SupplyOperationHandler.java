package core.basesyntax.services.operations;

import static core.basesyntax.db.Storage.fruitStorage;

import core.basesyntax.dto.FruitTransactionDto;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransactionDto dto) {
        if (fruitStorage.get(dto.fruitName()) == null) {
            fruitStorage.put(dto.fruitName(), dto.quantity());
            return;
        }
        fruitStorage.put(dto.fruitName(), dto.quantity() + fruitStorage.get(dto.fruitName()));
    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return "s".equals(dto.operationType());
    }
}
