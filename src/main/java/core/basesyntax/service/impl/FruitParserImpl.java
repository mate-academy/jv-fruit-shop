package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitParser;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FruitParserImpl implements FruitParser {
    @Override
    public List<Fruit> parse(List<FruitDto> data) {
        if (data == null || data.isEmpty()) {
            throw new NoSuchElementException();
        }
        List<Fruit> fruits = new ArrayList<>();
        for (FruitDto fruitDto : data) {
            fruits.add(new Fruit(fruitDto.getName(), fruitDto.getShelfLife()));
        }
        return fruits;
    }
}
