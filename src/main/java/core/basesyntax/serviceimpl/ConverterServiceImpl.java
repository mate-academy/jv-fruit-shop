package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ConverterService;
import core.basesyntax.model.Fruit;

import java.util.List;

public class ConverterServiceImpl implements ConverterService {
    private static final int typeIndex = 0;
    private static final int fruitIndex = 1;
    private static final int quantityIndex = 2;

    @Override
    public List<Fruit> convert(List<String> list) {

        for (String s : list) {
            String[] fruits = s.replaceAll("\\s+", "").split(",");
            String type = fruits[typeIndex];
            String fruit = fruits[fruitIndex];
            int quantity = Integer.parseInt(fruits[quantityIndex]);

            Storage.fruits.add(new Fruit(type, fruit, quantity));
        }
        return Storage.fruits;
    }

}
