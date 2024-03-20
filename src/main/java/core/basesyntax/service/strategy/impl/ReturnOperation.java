package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.exception.DataFileCorrupted;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.HashMap;

public class ReturnOperation implements OperationHandler {
    private StorageDaoImpl actionDB;

    public ReturnOperation(StorageDaoImpl actionDB) {
        this.actionDB = actionDB;
    }

    @Override
    public HashMap<String, Integer> apply(FruitTransactionDto dto) {
        try {
            HashMap<String,Integer> oldFrutitValue = actionDB.get(dto);
            FruitTransactionDto newFruitValue = new FruitTransactionDto(dto.operationType(),
                    dto.fruitName(),
                    oldFrutitValue.get(dto.fruitName()) + dto.quantity());
            return actionDB.change(newFruitValue);
        } catch (NullPointerException e) {
            throw new DataFileCorrupted("Trying to return fruits but"
                    + " there was no fruit in balance or supply which were purchased");
        }
    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return "r".equals(dto.operationType());
    }
}
