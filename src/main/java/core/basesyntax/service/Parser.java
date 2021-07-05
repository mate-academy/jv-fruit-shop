package core.basesyntax.service;

import core.basesyntax.dto.FruitDto;

public interface Parser {
    FruitDto parse(String element);
}
