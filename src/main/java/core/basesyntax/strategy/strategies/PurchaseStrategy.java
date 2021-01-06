package core.basesyntax.strategy.strategies;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationStrategy;

public class PurchaseStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        Integer quantity = Storage.storage.get(transactionDto.getFruit());
        Integer newQuantity = quantity
                - transactionDto.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("People want to buy more than we have");
        }
        Storage.storage.replace(transactionDto.getFruit(), newQuantity);
    }
}
