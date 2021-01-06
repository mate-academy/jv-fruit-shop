package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.NegativeQuantityException;
import core.basesyntax.model.TransactionDto;

public class ReductionStrategyImpl implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        String currentKey = transactionDto.getFruit().getName();
        if (Storage.getFruits().containsKey(currentKey)) {
            Integer newValue = Storage.getFruits().get(currentKey) - transactionDto.getQuantity();
            if (newValue < 0) {
                throw new NegativeQuantityException(String
                        .format("Buyers will not be able to buy %s %s, "
                                        + "because they are only %s units in stock.",
                                transactionDto.getQuantity(),
                                transactionDto.getFruit().getName(),
                                Storage.getFruits().get(currentKey)));
            }
            Storage.getFruits().put(currentKey, newValue);
            return;
        }
        throw new NegativeQuantityException("Can't apply transaction of "
                + transactionDto.getQuantity() + " items!");
    }
}
