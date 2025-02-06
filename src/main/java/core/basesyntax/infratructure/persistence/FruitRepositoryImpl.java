package core.basesyntax.infratructure.persistence;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.NoSuchElementException;

public class FruitRepositoryImpl implements FruitRepository {
    private final Map<String, Fruit> fruitMap;

    public FruitRepositoryImpl(Map<String, Fruit> fruitMap) {
        this.fruitMap = fruitMap;
    }

    @Override
    public Map<String, Fruit> getFruitMap() {
        return fruitMap;
    }

    @Override
    public void createFruit(Fruit fruit) {
        fruitMap.put(fruit.getName(), fruit);
    }

    @Override
    public void updateFruit(String fruitName, int amount) {
        Fruit fruit = fruitMap.get(fruitName);
        if (fruit == null) {
            throw new NoSuchElementException("Can't update fruit");
        }
        fruit.setAmount(amount);
        fruitMap.replace(fruitName, fruit);
    }

    @Override
    public void deleteFruit(String fruitName) {
        Fruit fruit = fruitMap.get(fruitName);
        if (fruit == null) {
            throw new NoSuchElementException("Can't delete fruit");
        }
        fruitMap.remove(fruitName);
    }

    @Override
    public Fruit getFruit(String fruitName) {
        Fruit fruit = fruitMap.get(fruitName);
        if (fruit == null) {
            throw new NoSuchElementException("Can't get fruit");
        }
        return fruitMap.get(fruitName);
    }
}
