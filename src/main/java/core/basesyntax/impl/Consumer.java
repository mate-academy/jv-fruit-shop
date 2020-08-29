package core.basesyntax.impl;

import core.basesyntax.model.FruitBox;
import core.basesyntax.model.Storage;
import core.basesyntax.service.Operator;
import core.basesyntax.service.SoldFruitCounter;
import java.util.NoSuchElementException;

public class Consumer implements Operator<FruitBox> {
    @Override
    public void execute(FruitBox fruit) {
        if (Storage.storage.peek() == null) {
            throw new NullPointerException("No fruits in storage");
        }
        if (fruit.getAmount() > Storage.storage.peek().getAmount()
                && Storage.storage.size() > 1) {
            int oldAmount = Storage.storage.poll().getAmount();
            Storage.storage.peek().setAmount(
                    Storage.storage.peek().getAmount() + oldAmount);
            Storage.storage.peek().setAmount(
                    Storage.storage.peek().getAmount() - fruit.getAmount());
            SoldFruitCounter.fruitCounter += fruit.getAmount();
        } else if (fruit.getAmount() <= Storage.storage.peek().getAmount()) {
            Storage.storage
                    .peek()
                    .setAmount(Storage.storage
                            .peek()
                            .getAmount() - fruit.getAmount());
            SoldFruitCounter.fruitCounter += fruit.getAmount();
        } else {
            throw new NoSuchElementException("Not enough fruits in storage");
        }
    }
}
