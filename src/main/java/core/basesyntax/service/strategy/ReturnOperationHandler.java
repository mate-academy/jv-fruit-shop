package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operations;
import java.util.Map;

public class ReturnOperationHandler implements OperationHandler {

    @Override
    public Operations getOperation() {
        return Operations.RETURN;
    }

    @Override
    public int applyOperation(int result, int quantity) {

        for (Map.Entry<String, Fruit> entry : Storage.getFruits().entrySet()) {
            String fruitName = entry.getKey();
            Fruit fruit = entry.getValue();

            int newQuantity = fruit.getQuantity() + quantity;
            fruit.setQuantity(newQuantity);

            Storage.getFruits().put(fruitName, fruit);
        }

        return result + quantity;
    }
}
