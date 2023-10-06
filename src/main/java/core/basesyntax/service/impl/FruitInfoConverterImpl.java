package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitInfoConverter;
import java.util.ArrayList;
import java.util.List;

public class FruitInfoConverterImpl implements FruitInfoConverter {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<Fruit> convertFruitInfo(String data) {
        String[] dataFruit = data.split(System.lineSeparator());
        List<Fruit> fruits = new ArrayList<>();
        for (int i = 1; i < dataFruit.length; i++) {
            String[] fruitLine = dataFruit[i].split(",");
            fruits.add(createFruit(fruitLine[0].charAt(0),
                                   fruitLine[1],
                                   Integer.parseInt(fruitLine[2])));
        }
        return fruits;
    }

    private Fruit createFruit(char type, String name, int amount) {
        return new Fruit(type, name, amount);
    }
}
