package core.basesyntax.dao;

import core.basesyntax.database.FruitsStorage;

public class FruitsDaoImpl implements FruitsDao {
    private static final int FRUIT_NAME_POSITION = 0;
    private static final int FRUIT_AMOUNT_POSITION = 1;

    @Override
    public boolean add(String[] fruits) {
        String fruit = fruits[FRUIT_NAME_POSITION];
        int amount = Integer.parseInt(fruits[FRUIT_AMOUNT_POSITION]);
        FruitsStorage.fruitsStorage.merge(fruit, amount, Integer::sum);
        return FruitsStorage.fruitsStorage.get(fruit) == null;
    }

    @Override
    public boolean remove(String[] fruits) {
        String fruit = fruits[FRUIT_NAME_POSITION];
        int amount = Integer.parseInt(fruits[FRUIT_AMOUNT_POSITION]);
        boolean contains = FruitsStorage.fruitsStorage.containsKey(fruit);
        if (contains && FruitsStorage.fruitsStorage.get(fruit) - amount < 0) {
            FruitsStorage.fruitsStorage.put(fruit, 0);
        } else if (contains) {
            FruitsStorage.fruitsStorage.merge(fruit, -amount, Integer::sum);
        }
        return contains;
    }
}
