package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.HashMap;

public class SupplyOperation implements OperationHandler {
    private final StorageDao actionDB;

    public SupplyOperation(StorageDaoImpl actionDB) {
        this.actionDB = actionDB;
    }

    @Override
    public HashMap<String, Integer> apply(FruitTransactionDto dto) {
        try {
            HashMap<String, Integer> oldFrutitValue = actionDB.get(dto);
            FruitTransactionDto newFruitValue = new FruitTransactionDto(dto.operationType(),
                    dto.fruitName(),
                    oldFrutitValue.get(dto.fruitName()) + dto.quantity());
            return actionDB.change(newFruitValue);
        } catch (NullPointerException e) {
            return actionDB.add(dto);
        }
    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return "s".equals(dto.operationType());
    }
}
