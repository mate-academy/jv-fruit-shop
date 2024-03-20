package core.basesyntax.service.impl;

import core.basesyntax.exceptions.InvalidOperationException;
import core.basesyntax.model.FruitsTransaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.impl.BalanceService;
import core.basesyntax.strategy.impl.PurchaseService;
import core.basesyntax.strategy.impl.ReturnService;
import core.basesyntax.strategy.impl.SupplyService;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    @Override
    public void executeTransactions(List<FruitsTransaction> transactions) {
        for (FruitsTransaction transaction : transactions) {
            switch (transaction.getOperation()) {
                case BALANCE -> new BalanceService().perform(transaction);
                case SUPPLY -> new SupplyService().perform(transaction);
                case PURCHASE -> new PurchaseService().perform(transaction);
                case RETURN -> new ReturnService().perform(transaction);
                default -> throw new InvalidOperationException("can`t act this operation");
            }
        }
    }
}
