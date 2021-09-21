package core.basesyntax.services;

import core.basesyntax.dto.FruitDto;
import java.util.List;

public interface FruitDtoParser {
    List<FruitDto> parseFruitDto(List<String> dataFromFile);
}
