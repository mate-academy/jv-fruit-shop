package core.basesyntax;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

public class BuyFruitsOperation implements StoreOperations {

    @Override
    public void action(List<Fruit> fruitList, String name, LocalDate date, Integer quantity) {
        Fruit finderFruit;
        if (fruitList.isEmpty()
                || (finderFruit = finderNecessaryFruitStorage(fruitList, name)) == null) {
            throw new NoSuchElementException("The desired fruit was not found in storage");
        }
        Map<LocalDate, Integer> storage = finderFruit.getStorage();
        finderFruit.setStorage(getFruits(storage, date, quantity));
    }

    private Fruit finderNecessaryFruitStorage(List<Fruit> list, String name) {
        for (Fruit fruit : list) {
            if (fruit.getName().equals(name)) {
                return fruit;
            }
        }
        return null;
    }

    private Map<LocalDate, Integer> getFruits(Map<LocalDate, Integer> storage,
                                              LocalDate date, Integer amountOfFruit) {
        Map<LocalDate, Integer> newMap = new HashMap<>(storage);
        int currentAmount = 0;
        //сортуємо, щоб брати фрукти перш ті що скоро зіпсуються
        Set<LocalDate> localDates = new TreeSet<>(storage.keySet());
        for (LocalDate localDate : localDates) {
            if (date.isBefore(localDate) && (currentAmount += storage.get(localDate)) != 0) {
                if (currentAmount > amountOfFruit) {
                    newMap.put(localDate, currentAmount - amountOfFruit);
                    return newMap;
                }
                newMap.remove(localDate);
            }
        }
        //коли всі фрукти прострочені вертаємо нову мапу без значень
        return new HashMap<>();
    }
}
