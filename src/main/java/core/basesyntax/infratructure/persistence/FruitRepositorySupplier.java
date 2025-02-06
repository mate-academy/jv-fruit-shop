package core.basesyntax.infratructure.persistence;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitRepositorySupplier {
    private static final int FRUIT_NAME_INDEX = 0;
    private static final int FRUIT_AMOUNT_INDEX = 1;

    public static Map<String, Fruit> get(List<String> fruitsDb) {
        Map<String, Fruit> fruitMap = new HashMap<>();

        String[] info = new String[2];
        for (String fruitStr : fruitsDb) {
            info = fruitStr.split(",");
            Fruit fruit = new Fruit(info[FRUIT_NAME_INDEX],
                    Integer.parseInt(info[FRUIT_AMOUNT_INDEX]));
            fruitMap.put(fruit.getName(), fruit);
        }

        return fruitMap;
    }
}
