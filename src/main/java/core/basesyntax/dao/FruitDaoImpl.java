package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.NoSuchElementException;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void addFruit(String fruit, int quantity) {
        if (Storage.fruits.containsKey(fruit)) {
            int currentQuantity = Storage.fruits.get(fruit);
            int newQuantity = currentQuantity + quantity;
            Storage.fruits.put(fruit, newQuantity);
        } else {
            Storage.fruits.put(fruit, quantity);
        }
    }

    @Override
    public void subtractFruit(String fruit, int quantity) {
        if (Storage.fruits.containsKey(fruit)) {
            int currentQuantity = Storage.fruits.get(fruit);
            if (currentQuantity >= quantity) {
                int newQuantity = currentQuantity - quantity;
                Storage.fruits.put(fruit, newQuantity);
            } else {
                throw new RuntimeException("Not enough " + fruit);
            }
        } else {
            throw new NoSuchElementException("This fruit doesn't exist");
        }
    }
}
