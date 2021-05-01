package core.basesyntax.service;

import core.basesyntax.dto.FruitDto;
import java.util.List;

public interface Parser {
    List<FruitDto> parseDto(List<String> information);
}
