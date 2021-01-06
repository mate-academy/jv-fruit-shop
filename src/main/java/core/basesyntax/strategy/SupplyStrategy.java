package core.basesyntax.strategy;

import core.basesyntax.basesyntaxdb.Storage;
import core.basesyntax.model.TransactionDto;

public class SupplyStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        for (int i = 0; i < transactionDto.getQuantity(); i++) {
            Storage.fruitList.add(transactionDto.getFruit());
        }
    }
}
