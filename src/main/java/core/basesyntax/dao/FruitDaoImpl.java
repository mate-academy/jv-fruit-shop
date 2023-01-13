package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public int getData(String fruit) {
        return FruitStorage.storageFruits.get(fruit);
    }

    @Override
    public void putInData(String fruit, int quantity) {
        FruitStorage.storageFruits.put(fruit, quantity);
    }

    @Override
    public void updateData(String fruit, int newQuantity) {
        FruitStorage.storageFruits.put(fruit, newQuantity);
    }

    @Override
    public Map<String, Integer> getAll() {
        return FruitStorage.storageFruits;
    }
}
