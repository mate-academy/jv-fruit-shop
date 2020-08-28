package core.basesyntax.operations;

import core.basesyntax.FruitStore;
import core.basesyntax.model.TransactionDto;
import java.time.LocalDate;

public class BuyOperation implements Operation {
    @Override
    public void apply(TransactionDto transactionDto) {
        String fruit = transactionDto.getFruit();
        int quantity = transactionDto.getQuantity();
        LocalDate purchaseDate = transactionDto.getPurchaseDate();
        if (FruitStore.fruitStorage.get(fruit) < quantity
                || !FruitStore.fruitStorage.containsKey(fruit)) {
            throw new RuntimeException("Fruits are not enough");
        }
        if (FruitStore.expirationDateStorage.get(fruit).isBefore(purchaseDate)) {
            throw new RuntimeException("Fruits are already expired");
        }
        FruitStore.fruitStorage.put(fruit, FruitStore.fruitStorage.get(fruit) - quantity);
    }
}
