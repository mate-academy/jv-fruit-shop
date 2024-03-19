package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.strategy.OperationHandler;

import java.util.HashMap;

public class SupplyOperationHandler implements OperationHandler {
    private StorageDaoImpl actionDB = new StorageDaoImpl();

    @Override
    public HashMap<String, Integer> apply(FruitTransactionDto dto) {
        HashMap<String,Integer> oldFrutitValue = actionDB.get(dto);
        FruitTransactionDto newFruitValue = new FruitTransactionDto(dto.operationType(), dto.fruitName(),
                oldFrutitValue.get(dto.fruitName()) + dto.quantity());
        return actionDB.change(newFruitValue);
    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return "s".equals(dto.operationType());
    }
}
