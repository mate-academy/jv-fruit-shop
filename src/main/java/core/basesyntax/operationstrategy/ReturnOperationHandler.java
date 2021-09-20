package core.basesyntax.operationstrategy;

import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.TransactionDto;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public Integer doOperation(TransactionDto fruitRecord) {
        return new FruitStorageDaoImpl().getAll().get(fruitRecord.getFruit())
                + fruitRecord.getFruitAmount();
    }
}
