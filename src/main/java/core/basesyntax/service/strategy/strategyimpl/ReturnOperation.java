package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.exception.WrongOperationException;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.HashMap;

public class ReturnOperation implements OperationHandler {
    private final StorageDao storageDao;

    public ReturnOperation(StorageDaoImpl storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public HashMap<String, Integer> apply(FruitTransactionDto dto) {
        try {
            HashMap<String,Integer> oldFrutitValue = storageDao.get(dto);
            FruitTransactionDto newFruitValue = new FruitTransactionDto(dto.operationType(),
                    dto.fruitName(),
                    oldFrutitValue.get(dto.fruitName()) + dto.quantity());
            return storageDao.change(newFruitValue);
        } catch (NullPointerException e) {
            throw new WrongOperationException("Trying to return fruits but"
                    + " there was no fruit in balance or supply which were purchased");
        }
    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return "r".equals(dto.operationType());
    }
}
