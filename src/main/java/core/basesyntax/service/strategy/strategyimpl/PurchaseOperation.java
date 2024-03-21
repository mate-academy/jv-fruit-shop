package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.exception.NegativeBalanceException;
import core.basesyntax.exception.WrongOperationException;
import core.basesyntax.model.Operation;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.HashMap;

public class PurchaseOperation implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperation(StorageDaoImpl storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransactionDto dto) {
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

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return dto.operationType() == Operation.PURCHASE;
    }

    @Override
    public Operation getOperation() {
        return Operation.PURCHASE;
    }
}
