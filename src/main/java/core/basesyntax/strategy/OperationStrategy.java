package core.basesyntax.strategy;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.strategies.BalanceStrategy;
import core.basesyntax.strategy.strategies.PurchaseStrategy;
import core.basesyntax.strategy.strategies.ReturnStrategy;
import core.basesyntax.strategy.strategies.SupplyStrategy;

public interface OperationStrategy {
    void apply(TransactionDto transactionDto);

    static void chooseTheStrategy(TransactionDto transactionDto) {
        switch (transactionDto.getOperation()) {
            case BALANCE: {
                OperationStrategy strategy = new BalanceStrategy();
                strategy.apply(transactionDto);
                break;
            }
            case SUPPLY: {
                OperationStrategy strategy = new SupplyStrategy();
                strategy.apply(transactionDto);
                break;
            }
            case PURCHASE: {
                OperationStrategy strategy = new PurchaseStrategy();
                strategy.apply(transactionDto);
                break;
            }
            case RETURN: {
                OperationStrategy strategy = new ReturnStrategy();
                strategy.apply(transactionDto);
                break;
            }
            default: {
                throw new RuntimeException("Incorrect operation: " + transactionDto.getOperation());
            }
        }
    }
}
