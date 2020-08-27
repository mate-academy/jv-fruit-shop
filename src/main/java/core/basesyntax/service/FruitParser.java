package core.basesyntax.service;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitParser {
    List<Fruit> parse(List<FruitDto> data);
}
