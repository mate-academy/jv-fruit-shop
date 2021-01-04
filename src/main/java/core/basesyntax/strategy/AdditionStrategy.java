package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import java.util.Map;

public class AdditionStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto, Storage storage) {
        Integer quantity = transactionDto.getQuantity();
        for (Map.Entry<Fruit, Integer> fruit: Storage.fruits.entrySet()) {
            if (fruit.getKey().equals(transactionDto.getFruit())) {
                quantity = fruit.getValue() + quantity;
                break;
            }
        }
        Storage.fruits.put(transactionDto.getFruit(), quantity);
    }
}
