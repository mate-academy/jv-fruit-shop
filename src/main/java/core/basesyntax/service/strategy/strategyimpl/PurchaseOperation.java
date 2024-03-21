package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.exception.DataFileCorrupted;
import core.basesyntax.exception.WrongOperationException;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.HashMap;

public class PurchaseOperation implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperation(StorageDaoImpl storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public HashMap<String, Integer> apply(FruitTransactionDto dto) {
        try {
            HashMap<String,Integer> oldFrutitValue = storageDao.get(dto);
            FruitTransactionDto newFruitValue = new FruitTransactionDto(dto.operationType(),
                    dto.fruitName(),
                    oldFrutitValue.get(dto.fruitName()) - dto.quantity());
            return storageDao.change(newFruitValue);
        } catch (NullPointerException e) {
            throw new WrongOperationException("Trying to purchase fruits that we dont have in Storage"
                    + " this means there wasnt any supply or balance operations"
                    + "in the incoming file");
        }

    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return "p".equals(dto.operationType());
    }
}
