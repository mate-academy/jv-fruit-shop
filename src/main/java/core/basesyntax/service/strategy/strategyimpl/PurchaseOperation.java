package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.exception.NegativeBalanceException;
import core.basesyntax.exception.WrongOperationException;
import core.basesyntax.service.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperation(StorageDaoImpl storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransactionDto dto) {
        Integer currentQuantity = storageDao.get(dto.fruitName());
        if (currentQuantity == null) {
            throw new WrongOperationException("Trying to purchase fruits"
                    + dto.fruitName()
                    + " that we "
                    + "dont have in Storage"
                    + " this means there wasnt any supply or balance operations"
                    + "in the incoming file");
        }
        int newQuantity = currentQuantity - dto.quantity();
        if (newQuantity < 0) {
            throw new NegativeBalanceException("Incorrect quantity,"
                    + " some operations probably missing,"
                    + " quantity for fruit"
                    + dto.fruitName()
                    + " is "
                    + newQuantity);
        }
        storageDao.add(dto.fruitName(), newQuantity);
    }
}
