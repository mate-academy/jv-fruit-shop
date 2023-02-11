package mate.academy.strategy.activities;

import static mate.academy.db.Storage.fruits;

import mate.academy.model.FruitTransaction;

public class AddActivityHandler implements ActivityHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        if (fruits.containsKey(transaction.getFruit())) {
            fruits.put(transaction.getFruit(),
                    fruits.get(transaction.getFruit()) + transaction.getQuantity());
        } else {
            fruits.put(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
