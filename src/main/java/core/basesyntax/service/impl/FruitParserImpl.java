package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitParser;
import java.util.NoSuchElementException;

public class FruitParserImpl implements FruitParser {
    @Override
    public Fruit parse(FruitDto fruitDto) {
        if (fruitDto == null) {
            throw new NoSuchElementException();
        }
        return new Fruit(fruitDto.getName(), fruitDto.getShelfLife());
    }
}
