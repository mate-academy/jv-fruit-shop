package core.basesyntax.service.transactions;

import core.basesyntax.service.interfaces.strategy.TransactionHandler;

public class BalanceTransactionHandler implements TransactionHandler {
    @Override
    public Integer getCurrentQuantity(Integer currentQuantity, Integer newQuantity) {
        return newQuantity;
    }
}
