package core.basesyntax.operationstrategy;

import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.TransactionDto;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public Integer doOperation(TransactionDto fruitRecord) {
        int fruitsQuantityAfterBuy = new FruitStorageDaoImpl().getAll()
                .get(fruitRecord.getFruit()) - fruitRecord.getFruitAmount();
        if (fruitsQuantityAfterBuy < 0) {
            throw new RuntimeException("Incorrect operation: "
                    + fruitRecord
                    + ". Not enough fruits to buy");
        }
        return fruitsQuantityAfterBuy;
    }
}
