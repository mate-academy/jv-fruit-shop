package mate.academy.strategy.activities;

import static mate.academy.db.Storage.fruits;

import mate.academy.model.FruitTransaction;

public class SubtractActivityHandler implements ActivityHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        if (fruits.containsKey(transaction.getFruit())) {
            fruits.put(transaction.getFruit(),
                    fruits.get(transaction.getFruit()) - transaction.getQuantity());
        } else {
            throw new RuntimeException("Can`t subtract non-existent" + transaction.getFruit());
        }
    }
}
