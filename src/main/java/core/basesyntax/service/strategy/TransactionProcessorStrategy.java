package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.strategy.impl.AdditionToStorageService;
import core.basesyntax.service.strategy.impl.InitialFruitsService;
import core.basesyntax.service.strategy.impl.SelloutService;
import java.util.List;
import java.util.Map;

public class TransactionProcessorStrategy implements TransactionProcessor {
    @Override
    public void process(List<FruitTransaction> transactions, Map<String, Integer> fruits) {
        for (FruitTransaction transaction : transactions) {
            switch (transaction.getOperation()) {
                case BALANCE:
                    new InitialFruitsService().process(transaction, fruits);
                    break;
                case PURCHASE:
                    new SelloutService().process(transaction, fruits);
                    break;
                case SUPPLY:
                case RETURN:
                    new AdditionToStorageService().process(transaction,fruits);
                    break;
                default:
                    break;
            }
        }
    }
}
