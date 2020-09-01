package core.basesyntax.service;

import core.basesyntax.impl.SupplyOperation;
import core.basesyntax.model.FruitBox;
import core.basesyntax.model.Storage;
import java.time.LocalDate;
import java.util.NoSuchElementException;

public class StorageService {
    public void addProduct(FruitBox fruit) {
        if (Storage.storage.peek() == null) {
            Storage.storage.add(fruit);
            return;
        }
        if (Storage.storage.peek().getExpiryDate().equals(fruit.getExpiryDate())) {
            Storage.storage.peek().setAmount(Storage.storage.peek().getAmount()
                    + fruit.getAmount());
            return;
        }
        if (fruit.getExpiryDate().isBefore(Storage.storage.peek().getExpiryDate())) {
            Storage.storage.addFirst(fruit);
            return;
        }
        Storage.storage.add(fruit);
    }

    public void sellProduct(FruitBox fruit) {
        if (Storage.storage.peek() == null) {
            throw new NoSuchElementException("No fruits in storage");
        }
        if (fruit.getAmount() > Storage.storage.peek().getAmount()
                && Storage.storage.size() > 1) {
            int oldAmount = Storage.storage.poll().getAmount();
            Storage.storage.peek().setAmount(
                    Storage.storage.peek().getAmount() + oldAmount);
            Storage.storage.peek().setAmount(
                    Storage.storage.peek().getAmount() - fruit.getAmount());
            FruitCounter.fruitCounter += fruit.getAmount();
        } else if (fruit.getAmount() <= Storage.storage.peek().getAmount()) {
            Storage.storage
                    .peek()
                    .setAmount(Storage.storage
                            .peek()
                            .getAmount() - fruit.getAmount());
            FruitCounter.fruitCounter += fruit.getAmount();
        } else {
            throw new NoSuchElementException("Not enough fruits in storage");
        }
    }

    public void returnProduct(FruitBox fruit) {
        LocalDate dateNow = LocalDate.now();
        Operator<FruitBox> supplier = new SupplyOperation();
        if (FruitCounter.fruitCounter < fruit.getAmount()
                || fruit.getExpiryDate().isBefore(dateNow)) {
            throw new RuntimeException("We can not accept this fruits!");
        }
        supplier.execute(fruit);
    }
}
