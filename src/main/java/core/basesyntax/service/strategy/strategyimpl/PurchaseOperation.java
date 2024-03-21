package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.dto.FruitTransactionDto;
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
        HashMap<String, Integer> fruitValue = storageDao.get(dto.fruitName());
        if (fruitValue == null) {
            throw new WrongOperationException("Trying to purchase fruits"
                    + dto.fruitName()
                    + " that we "
                    + "dont have in Storage"
                    + " this means there wasnt any supply or balance operations"
                    + "in the incoming file");
        }
        int newQuantity = fruitValue.get(dto.fruitName()) - dto.quantity();
        storageDao.add(dto.fruitName(), newQuantity);
        return storageDao.add(dto.fruitName(), newQuantity);
    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return "p".equals(dto.operationType());
    }
}
