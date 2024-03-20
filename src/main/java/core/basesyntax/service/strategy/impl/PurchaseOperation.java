package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.exception.DataFileCorrupted;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.HashMap;

public class PurchaseOperation implements OperationHandler {
    private StorageDaoImpl actionDB = new StorageDaoImpl();

    @Override
    public HashMap<String, Integer> apply(FruitTransactionDto dto) {
        try {
            HashMap<String,Integer> oldFrutitValue = actionDB.get(dto);
            FruitTransactionDto newFruitValue = new FruitTransactionDto(dto.operationType(),
                    dto.fruitName(),
                    oldFrutitValue.get(dto.fruitName()) - dto.quantity());
            return actionDB.change(newFruitValue);
        } catch (NullPointerException e) {
            throw new DataFileCorrupted("Trying to purchase fruits that we dont have in Storage"
                    + " this means there wasnt any supply or balance operations"
                    + "in the incoming file");
        }

    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return "p".equals(dto.operationType());
    }
}
