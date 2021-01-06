package core.basesyntax.strategy.strategies;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationStrategy;

public class ReturnStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        Integer newQuantity = Storage.storage.get(transactionDto.getFruit())
                + transactionDto.getQuantity();
        Storage.storage.replace(transactionDto.getFruit(), newQuantity);
    }
}
