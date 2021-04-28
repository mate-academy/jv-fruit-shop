package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.exceptions.IncorrectPurchaseRequestException;
import core.basesyntax.filework.AfterReadListStorage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class MagazineDaoImpl implements MagazineDao {

    @Override
    public Fruit getFruit(String fruitName) {
        return AfterReadListStorage.fruitStore.stream()
                .filter(a -> a.getFruitName().equals(fruitName))
                .findFirst().get();
    }

    @Override
    public void updateQuantity(Fruit fruit) {
        Map<String, Integer> actualStorage = FruitStorage.storage;
        Fruit fruitFromStorage = getFruit(fruit.getFruitName());

        if (!actualStorage.containsKey(fruitFromStorage.getFruitName())) {
            actualStorage.put(fruitFromStorage.getFruitName(), fruitFromStorage.getQuantity());
        } else {
            int oldValue = actualStorage.get(fruit.getFruitName());
            int newValue = oldValue + fruit.getQuantity();
            if (isValid(newValue, fruit)) {
                actualStorage.put(fruit.getFruitName(), newValue);
            }
        }
    }

    private boolean isValid(int value, Fruit fruit) {
        if (value < 0) {
            throw new IncorrectPurchaseRequestException("You can't buy "
                    + -fruit.getQuantity() + " " + fruit.getFruitName()
                    + "'s because it left not enough");
        }
        return true;
    }
}
