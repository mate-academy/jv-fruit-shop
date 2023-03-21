package core.basesyntax.service.transactions;

import core.basesyntax.service.interfaces.strategy.TransactionHandler;

public class SupplyTransactionHandler implements TransactionHandler {
    @Override
    public Integer getCurrentQuantity(Integer currentQuantity, Integer newQuantity) {
        return currentQuantity + newQuantity;
    }
}
