package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionStrategy;
import core.basesyntax.service.impl.TransactionStrategyImpl;

public class TransactionHandlerReturnImpl implements TransactionHandler {
    @Override
    public TransactionStrategy makeTransaction(FruitTransaction transaction) {
        if (Storage.fruits.get(transaction.getFruitName()) != null) {
            int result = Storage.fruits.get(transaction.getFruitName()) + transaction.getQuantity();
            if (result < 0) {
                throw new RuntimeException("Balance couldn't be less '0' "
                        + "after returned: balance " + transaction.getFruitName() + " = " + result);
            } else if (transaction.getQuantity() < 0) {
                throw new RuntimeException("Returned quantity couldn't be less '0'.\n"
                        + "Invalid data received from input file: return "
                        + transaction.getFruitName() + " = " + transaction.getQuantity());
            }
            Storage.fruits.put(transaction.getFruitName(), result);
            return new TransactionStrategyImpl();
        }
        throw new RuntimeException("This fruit: " + transaction.getFruitName()
                + " has not been sold and cannot be returned.");
    }
}
