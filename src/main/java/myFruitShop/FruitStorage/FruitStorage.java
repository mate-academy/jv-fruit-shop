package myFruitShop.FruitStorage;

import myFruitShop.model.Fruit;

import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
   private static final Map<Fruit, Integer> storage = new HashMap<Fruit,Integer>();

   public static Map<Fruit, Integer> getStorage() {
      return storage;
   }
}
