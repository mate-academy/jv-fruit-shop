package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruit : fruitTransactions) {
            int quantity = fruit.getQuantity();
            String fruitName = fruit.getFruit();
            String code = fruit.getOperation().getCode();
            if (code.equals("b")) {
                Storage.storage.put(fruit.getFruit(), quantity);
            } else {
               int actualQuantity = Storage.storage.get(fruitName);
                switch (code) {
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
        }
    }
}
