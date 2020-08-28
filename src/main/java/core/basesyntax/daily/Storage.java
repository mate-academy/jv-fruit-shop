package core.basesyntax.daily;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final List<Fruit> fruits = new ArrayList<>();

    public void add(Fruit fruit) {
        fruits.add(fruit);
    }

    public void remove(Fruit fruit) {
        for (int i = 0; i < fruits.size(); i++) {
            if (fruit.getFruitName().equals(fruits.get(i).getFruitName())
                    && fruit.getLocalDate().isBefore(fruits.get(i).getLocalDate())) {
                fruits.remove(i);
                return;
            }
        }
        throw new RuntimeException("incorrect purchase data");
    }
}
