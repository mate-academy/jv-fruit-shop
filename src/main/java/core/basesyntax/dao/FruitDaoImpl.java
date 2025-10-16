package core.basesyntax.dao;

import core.basesyntax.db.FruitDB;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    private final FruitDB fruitDB;

    public FruitDaoImpl(FruitDB fruitDB) {
        this.fruitDB = fruitDB;
    }

    @Override
    public void set(String fruit, Integer quantity) {
        validateFruitName(fruit);
        validateNonNegativeQuantity(quantity);
        fruitDB.setQuantity(fruit, quantity);
    }

    @Override
    public void add(String fruit, Integer quantity) {
        validateFruitName(fruit);
        validateNonNegativeQuantity(quantity);

        int current = safeGetQuantity(fruit);
        int updated = current + quantity;
        fruitDB.setQuantity(fruit, updated);
    }

    @Override
    public void remove(String fruit, Integer quantity) {
        validateFruitName(fruit);
        validateNonNegativeQuantity(quantity);

        int current = safeGetQuantity(fruit);
        int updated = current - quantity;

        if (updated < 0) {
            throw new RuntimeException(String.format(
                    "Cannot remove %d of '%s' (line would"
                            + " result in negative balance). Current:"
                            + " %d, attempted remove: %d",
                    quantity, fruit, current, quantity));
        }

        fruitDB.setQuantity(fruit, updated);
    }

    @Override
    public Map<String, Integer> getFruits() {
        return fruitDB.getFruits();
    }

    private int safeGetQuantity(String fruit) {
        Integer q = fruitDB.getQuantity(fruit);
        return q == null ? 0 : q;
    }

    private void validateFruitName(String fruit) {
        if (fruit == null || fruit.isBlank()) {
            throw new IllegalArgumentException("Fruit name"
                    + " must not be null or blank");
        }
    }

    private void validateNonNegativeQuantity(Integer quantity) {
        if (quantity == null) {
            throw new IllegalArgumentException("Quantity must"
                    + " not be null");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must"
                    + " not be negative: " + quantity);
        }
    }
}
