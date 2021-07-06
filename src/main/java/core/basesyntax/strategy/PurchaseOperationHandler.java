package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;
import core.basesyntax.service.impl.DataValidatorServiceImpl;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transaction) {
        DataValidatorServiceImpl validator = new DataValidatorServiceImpl();
        int oldQuantity = Storage.data.get(transaction.getFruit());
        int newQuantity = oldQuantity - transaction.getQuantity();
        if (validator.checkOperation(newQuantity)) {
            Storage.data.put(transaction.getFruit(), newQuantity);
        }
        return newQuantity;
    }
}
