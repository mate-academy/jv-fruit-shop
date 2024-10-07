package service.strategy.strategyimpl;

import dao.Storage;
import model.FruitRecord;


public class ReturnOperation implements OperationHandler {

    @Override
    public void apply(FruitRecord transaction) {
        int returnFruits = transaction.getQuantity();
        Storage.storage.merge(transaction.getFruit(),returnFruits, Integer::sum);
    }
}
