package service.activities;

import db.FruitShop;
import model.FruitTransaction;

public class BalanceActivitiesHandler implements ActivitiesHandler {

    @Override
    public void executeTransaction(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();

        if (quantity < 0) {
            throw new RuntimeException("Initial quantity cannot be negative for fruit: " + fruit);
        }

        FruitShop.fruitShop
                .stream()
                .filter(operation -> operation.getFruit().equals(fruit))
                .findFirst()
                .ifPresentOrElse(
                        existingTransaction -> {},
                        () -> FruitShop.fruitShop.add(fruitTransaction)
                );
    }
}

