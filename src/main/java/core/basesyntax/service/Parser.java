package core.basesyntax.service;

import core.basesyntax.model.OperationFruitDto;

public interface Parser {
    OperationFruitDto parse(String string);
}
