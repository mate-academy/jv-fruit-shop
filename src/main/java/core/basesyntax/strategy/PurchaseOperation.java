package core.basesyntax.strategy;

import core.basesyntax.dao.Storage;
import core.basesyntax.dto.Transaction;
import core.basesyntax.services.Validator;
import core.basesyntax.services.impl.ValidatorImpl;

public class PurchaseOperation implements Operation {
    @Override
    public int apply(Transaction transaction) {
        Validator validator = new ValidatorImpl();
        Storage.fruitStorage.computeIfAbsent(transaction.getFruit().getFruitName(),
                k -> transaction.getQuantity());
        int oldQuantity = Storage.fruitStorage.get(transaction.getFruit().getFruitName());
        int newQuantity = oldQuantity - transaction.getQuantity();
        if (validator.checkOperation(newQuantity)) {
            Storage.fruitStorage.put(transaction.getFruit().getFruitName(), newQuantity);
        }
        return newQuantity;
    }
}
