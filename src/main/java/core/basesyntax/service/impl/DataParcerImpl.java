package core.basesyntax.service.impl;

import core.basesyntax.fruit.Fruit;
import core.basesyntax.service.DataParcer;
import java.util.ArrayList;
import java.util.List;

public class DataParcerImpl implements DataParcer {
    private static final int HEAD_OF_FILE = 0;

    @Override
    public List<Fruit> getFruitsMoving(List<String> list) {
        list.remove(HEAD_OF_FILE);
        List<Fruit> listFruitsMoving = new ArrayList<>();
        String[] fields;
        for (String line : list) {
            fields = line.split(",");
            listFruitsMoving
                    .add(new Fruit(fields[0], fields[1], Integer.parseInt(fields[2])));
        }
        return listFruitsMoving;
    }
}
