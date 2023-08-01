package core.basesyntax.operations;

import core.basesyntax.exceptions.InvalidOperationException;
import core.basesyntax.transactions.FruitTransaction;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public void get(FruitTransaction transaction) {
        switch (transaction.getOperation()) {
            case BALANCE: {
                new BalanceOperationHandler()
                        .changeFruitQuantity(transaction.getFruit(), transaction.getQuantity());
                break;
            }
            case PURCHASE: {
                new PurchaseOperationHandler()
                        .changeFruitQuantity(transaction.getFruit(), transaction.getQuantity());
                break;
            }
            case RETURN: {
                new ReturnOperationHandler()
                        .changeFruitQuantity(transaction.getFruit(), transaction.getQuantity());
                break;
            }
            case SUPPLY: {
                new SupplyOperationHandler()
                        .changeFruitQuantity(transaction.getFruit(), transaction.getQuantity());
                break;
            }
            default: throw new InvalidOperationException("Wrong operation");
        }
    }
}
