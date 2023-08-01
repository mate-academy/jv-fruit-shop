package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;

import java.util.Stack;

public class FruitShopServiceImpl implements FruitShopService {

    @Override
    public void processStorage() {
        for (FruitTransaction fruitTransaction : Storage.transactionStorage) {
            String fruitName = fruitTransaction.getFruit();

            if (fruitTransaction.getOperation().equals(Operation.BALANCE)) {
                int quantity = fruitTransaction.getQuantity();

                Storage.fruitStorage.put(fruitName, quantity);
            }
            if (fruitTransaction.getOperation().equals(Operation.SUPPLY)) {
                int supplyQuantity = fruitTransaction.getQuantity();
                int currentQuantity = Storage.fruitStorage.get(fruitName);

                Storage.fruitStorage.put(fruitName, currentQuantity + supplyQuantity);
            }
            if (fruitTransaction.getOperation().equals(Operation.PURCHASE)) {
                int supplyQuantity = fruitTransaction.getQuantity();
                int currentQuantity = Storage.fruitStorage.get(fruitName);

                Storage.fruitStorage.put(fruitName, currentQuantity - supplyQuantity);
            }
            if (fruitTransaction.getOperation().equals(Operation.RETURN)) {
                int supplyQuantity = fruitTransaction.getQuantity();
                int currentQuantity = Storage.fruitStorage.get(fruitName);

                Storage.fruitStorage.put(fruitName, currentQuantity + supplyQuantity);
            }
        }
    }
}
