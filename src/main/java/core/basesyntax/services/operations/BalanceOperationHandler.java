package core.basesyntax.services.operations;

import static core.basesyntax.db.Storage.fruitStorage;

import core.basesyntax.dto.FruitTransactionDto;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransactionDto dto) {
        fruitStorage.put(dto.fruitName(), dto.quantity());
    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return "b".equals(dto.operationType());
    }
}
