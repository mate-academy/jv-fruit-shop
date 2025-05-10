package core.basesyntax.services.operations;

import static core.basesyntax.db.Storage.fruitStorage;

import core.basesyntax.dto.FruitTransactionDto;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransactionDto dto) {
        fruitStorage.merge(dto.fruitName(), dto.quantity(), Integer::sum);
    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return "r".equals(dto.operationType());
    }
}
