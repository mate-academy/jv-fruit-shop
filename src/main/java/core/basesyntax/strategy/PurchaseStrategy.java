package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import java.util.Map;
import java.util.NoSuchElementException;

public class PurchaseStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transaction) {
        Map<Fruit, Integer> data = Storage.getFruits();
        if (data.containsKey(transaction.getFruit())) {
            int countInStorage = data.get(transaction.getFruit());
            int result = countInStorage - transaction.getQuantity();
            if (result < 0) {
                throw new RuntimeException(String.format("Can't buy %d %s. Maximum is %d",
                        transaction.getQuantity(),
                        transaction.getFruit().getFruitName(), countInStorage));
            }
            data.replace(transaction.getFruit(), result);
            return;
        }
        throw new NoSuchElementException(
                String.format("Element %s not found in shop",
                        transaction.getFruit().getFruitName()));
    }
}
