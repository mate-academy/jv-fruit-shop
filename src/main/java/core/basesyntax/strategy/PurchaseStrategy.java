package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;
import java.util.NoSuchElementException;

public class PurchaseStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transaction) {
        if (Storage.getFruits().containsKey(transaction.getFruit())) {
            int countInStorage = Storage.getFruits().get(transaction.getFruit());
            int result = countInStorage - transaction.getQuantity();
            if (result < 0) {
                throw new RuntimeException(String.format("Can't buy %d %s. Maximum is %d",
                        transaction.getQuantity(),
                        transaction.getFruit().getFruitName(), countInStorage));
            }
            Storage.getFruits().replace(transaction.getFruit(), result);
            return;
        }
        throw new NoSuchElementException(
                String.format("Element %s not found in shop",
                        transaction.getFruit().getFruitName()));
    }
}
