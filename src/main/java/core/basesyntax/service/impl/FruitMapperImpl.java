package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitMapper;
import java.util.NoSuchElementException;

public class FruitMapperImpl implements FruitMapper {
    @Override
    public Fruit parse(FruitDto fruitDto) {
        if (fruitDto == null) {
            throw new NoSuchElementException();
        }
        return new Fruit(fruitDto.getName(), fruitDto.getShelfLife());
    }
}
