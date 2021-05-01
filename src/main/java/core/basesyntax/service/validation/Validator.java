package core.basesyntax.service.validation;

import core.basesyntax.dto.FruitDto;

public interface Validator {
    void validateFile(FruitDto fruitDto);
}
