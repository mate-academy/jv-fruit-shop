package core.basesyntax.dao;

public interface FruitDao {
   void putFruitToStorage(String fruitName, int fruitQuantity);
   Integer getFruit(String fruitName);
}
