package core.basesyntax.operations;

import core.basesyntax.FruitStore;
import core.basesyntax.model.TransactionDto;
import java.time.LocalDate;

public class SupplyAndReturnOperation implements Operation {
    @Override
    public void apply(TransactionDto transactionDto) {
        String fruit = transactionDto.getFruit();
        int quantity = transactionDto.getQuantity();
        LocalDate expirationDate = transactionDto.getPurchaseDate();
        FruitStore.fruitStorage.merge(fruit, quantity, Integer::sum);
        FruitStore.expirationDateStorage.put(fruit, expirationDate);
    }
}
