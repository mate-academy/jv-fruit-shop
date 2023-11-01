package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    private static final String ADD_FIRST_FAILURE_MESSAGE = "Product {%s} "
            + "already exist in storage!";
    private static final String ADDING_FAILURE_MESSAGE = "Product {%s} "
            + "does not exist in storage!";
    private static final int GET_FAILURE_INDEX = -1;

    @Override
    public void addFirst(String fruitName, int amount) {
        if (checkProductAlreadyExist(fruitName)) {
            throw new RuntimeException(String.format(ADD_FIRST_FAILURE_MESSAGE, fruitName));
        }
        FruitStorage.goods.put(new Fruit(fruitName), amount);
    }

    @Override
    public void add(String fruitName, int amount) {
        if (!checkProductAlreadyExist(fruitName)) {
            throw new RuntimeException(String.format(ADDING_FAILURE_MESSAGE, fruitName));
        }
        for (Map.Entry<Fruit, Integer> good : FruitStorage.goods.entrySet()) {
            if (fruitName.equals(good.getKey().getProductName())) {
                good.setValue(good.getValue() + amount);
                break;
            }
        }
    }

    @Override
    public Integer get(String fruitName) {
        for (Map.Entry<Fruit, Integer> good : FruitStorage.goods.entrySet()) {
            if (fruitName.equals(good.getKey().getProductName())) {
                return good.getValue();
            }
        }
        return GET_FAILURE_INDEX;
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return FruitStorage.goods;
    }

    @Override
    public void remove(String fruitName, int amount) {
        for (Map.Entry<Fruit, Integer> good : FruitStorage.goods.entrySet()) {
            if (fruitName.equals(good.getKey().getProductName())) {
                good.setValue(good.getValue() - amount);
                break;
            }
        }
    }

    private boolean checkProductAlreadyExist(String fruitName) {
        return FruitStorage.goods
                .entrySet()
                .stream()
                .anyMatch(product -> product.getKey().getProductName().equals(fruitName));
    }
}
