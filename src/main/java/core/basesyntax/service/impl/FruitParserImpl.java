package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitParser;
import java.time.LocalDate;
import java.util.List;

public class FruitParserImpl implements FruitParser {
    @Override
    public Fruit parse(List<String> params) {
        if (params == null) {
            throw new NullPointerException();
        }
        String name = params.get(1);
        int quantity = Integer.parseInt(params.get(2));
        LocalDate shelfLife = LocalDate.parse(params.get(3));
        return new Fruit(name, quantity, shelfLife);
    }
}
