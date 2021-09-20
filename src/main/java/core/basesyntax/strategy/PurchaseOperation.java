package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;
import core.basesyntax.service.Validator;
import core.basesyntax.service.ValidatorImpl;

public class PurchaseOperation implements Operation {
    @Override
    public int apply(Transaction transaction) {
        Validator validator = new ValidatorImpl();
        int oldQuantity = Storage.data.get(transaction.getFruit());
        int newQuantity = oldQuantity - transaction.getQuantity();
        if (validator.checkOperation(newQuantity)) {
            Storage.data.put(transaction.getFruit(), newQuantity);
        }
        return newQuantity;
    }
}
