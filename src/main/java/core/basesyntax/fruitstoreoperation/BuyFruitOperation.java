package core.basesyntax.fruitstoreoperation;

import core.basesyntax.Storage;
import core.basesyntax.exception.NoSuchFruitException;
import core.basesyntax.exception.NotEnoughFruitException;
import core.basesyntax.model.InputDataModel;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

public class BuyFruitOperation implements FruitStoreOperation {
    private Storage storage;

    public BuyFruitOperation() {
        this.storage = new Storage();
    }

    public void doOperation(InputDataModel product, int amount) {
        Map<InputDataModel, Integer> necessaryFruits =
                storage.getAllFruits().entrySet().stream()
                        .filter(p -> p.getKey().getName().equals(product.getName()))
                        .filter(p -> LocalDate.now().isBefore(p.getKey().getDate())
                                || LocalDate.now().equals(p.getKey().getDate()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        int numberOfAvailableFruits = necessaryFruits.values().stream()
                .mapToInt(i -> i).sum();
        if (numberOfAvailableFruits == 0) {
            throw new NoSuchFruitException("No such fruit in store");
        }
        if (numberOfAvailableFruits < amount) {
            throw new NotEnoughFruitException(String.format(
                    "Insufficient amount of fruit in the store:"
                            + " request for %s, but %s is available",
                    amount, numberOfAvailableFruits));
        }
        Iterator<Map.Entry<InputDataModel, Integer>> iterator
                = necessaryFruits.entrySet().iterator();
        int counter = amount;
        while (iterator.hasNext() && counter > 0) {
            Map.Entry<InputDataModel, Integer> entry = iterator.next();
            if (entry.getValue() > counter) {
                storage.changeAmountOfFruitProduct(entry.getKey(), amount);
                counter = 0;
            } else {
                counter = amount - entry.getValue();
                storage.removeFruitProduct(entry.getKey());
            }
        }
    }
}
