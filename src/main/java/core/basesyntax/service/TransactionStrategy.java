package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.DataBase;

public class TransactionStrategy {
    private static int balanceFruits = 0;
    private static int purchaseFruits = 0;
    private static int returnFruits = 0;
    private static int supplyFruits = 0;

    public void getShopService() {
        DataBase.fruitDataBase.forEach(fruitTransaction -> {
            if (fruitTransaction.getOperation() == FruitTransaction.Operation.BALANCE) {
                balanceFruits++;
            } else if (fruitTransaction.getOperation() == FruitTransaction.Operation.PURCHASE) {
                purchaseFruits++;
            } else if (fruitTransaction.getOperation() == FruitTransaction.Operation.RETURN) {
                returnFruits++;
            } else if (fruitTransaction.getOperation() == FruitTransaction.Operation.SUPPLY) {
                supplyFruits++;
            }
        });

        if (balanceFruits > 0) {
            new BalanceService().operationHandler();
        }
        if (purchaseFruits > 0) {
            new PurchaseService().operationHandler();
        }
        if (returnFruits > 0) {
            new ReturnService().operationHandler();
        }
        if (supplyFruits > 0) {
            new SupplyService().operationHandler();
        }
    }
}
