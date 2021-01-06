package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class ReductionStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        checkExceptionNegativeCount(transactionDto);
        int count = 0;
        for (Fruit fruit : Storage.fruits) {
            if (fruit.equals(transactionDto.getFruit())) {
                count++;
            }
        }
        if (count < transactionDto.getCount()) {
            throw new RuntimeException("Buyers will not be able to buy "
                    + transactionDto.getCount() + " " + transactionDto.getFruit().getName()
                    + "(s), because they are only " + count + " units in stock.");
        }
        for (int i = 0; i < transactionDto.getCount(); i++) {
            Storage.fruits.remove(transactionDto.getFruit());
        }
    }
}
