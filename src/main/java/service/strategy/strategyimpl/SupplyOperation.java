package service.strategy.strategyimpl;

import dao.Storage;
import model.FruitRecord;

public class SupplyOperation implements OperationHandler{

    @Override
    public void apply(FruitRecord transaction) {
        int supplyQuantity = transaction.getQuantity();
        Storage.storage.merge(transaction.getFruit(), supplyQuantity, Integer::sum);
    }
}
