package core.basesyntax.service;

import core.basesyntax.products.Fruit;
import core.basesyntax.storage.ListStorage;

import java.time.LocalDate;
import java.util.Map;

public class SupplyService implements Handleable {
    @Override
    public void operationWithProduct(Fruit fruit) {
        LocalDate fruitDate = fruit.getDate();
        String fruitName = fruit.getName();

        for (Fruit element : ListStorage.listStorage) {
            if (element.getName().equals(fruitName)
                    && element.getDate().isEqual(fruitDate)) {
                element.setAmount(element.getAmount() + fruit.getAmount());
                return;
            }
        }
        ListStorage.listStorage.add(fruit);
    }
}
