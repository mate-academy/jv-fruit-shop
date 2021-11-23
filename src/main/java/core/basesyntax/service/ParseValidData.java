package core.basesyntax.service;

import core.basesyntax.model.OperationFruitDto;

public interface ParseValidData {
    OperationFruitDto parseValidDataImpl(String string);
}
