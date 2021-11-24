package core.basesyntax.service;

import core.basesyntax.model.OperationFruitDto;

public interface ParserValidData {
    OperationFruitDto parse(String string);
}
