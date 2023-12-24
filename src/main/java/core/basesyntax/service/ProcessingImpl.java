package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.ArrayList;

public class ProcessingImpl implements Processing {
    @Override
    public boolean makeTransaction(ArrayList<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruit : fruitTransactions) {
            int quantity = fruit.getQuantity();
            String fruitName = fruit.getFruit();
            int actualQuantity = Storage.storage.get(fruitName);
            String code = fruit.getOperation().getCode();
            switch (code) {
                case "b":
                    actualQuantity = quantity;
                    break;
                case "s":
                case "r":
                    actualQuantity += quantity;
                    break;
                case "p":
                    actualQuantity -= quantity;
                    break;
                default:
                    throw new RuntimeException("You entered the wrong symbol!");
            }
            Storage.storage.replace(fruit.getFruit(), actualQuantity);
        }
        return true;
    }
}
