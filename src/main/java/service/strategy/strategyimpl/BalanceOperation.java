package service.strategy.strategyimpl;

import dao.Storage;
import model.FruitRecord;

public class BalanceOperation  implements OperationHandler{
    @Override
    public void apply(FruitRecord transaction) {
        Storage.storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
