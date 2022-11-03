package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Fruit add(String fruitName) {
        Fruit fruit = new Fruit();
        fruit.setName(fruitName);
        FruitStorage.fruitsInShop.add(fruit);
        return fruit;
    }

    @Override
    public Fruit get(FruitTransaction fruitTransaction) {
        return FruitStorage.fruitsInShop.stream()
                .filter(f -> f.getName().equals(fruitTransaction.getFruitName()))
                .findFirst()
                .orElseGet(() -> add(fruitTransaction.getFruitName()));
    }

    @Override
    public List<Fruit> getAll() {
        List<Fruit> fruitInShopList = FruitStorage.fruitsInShop;
        return fruitInShopList;
    }

    @Override
    public void update(FruitTransaction fruitTransaction, int newAmount) {
        Fruit fruitFromDb = get(fruitTransaction);
        fruitFromDb.setAmountInShop(newAmount);
    }
}
