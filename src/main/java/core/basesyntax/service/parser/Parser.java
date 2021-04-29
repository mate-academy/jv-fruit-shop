package core.basesyntax.service.parser;

import core.basesyntax.dto.FruitDto;
import java.util.List;

public interface Parser {
    List<FruitDto> parseInformation(List<String> fruitList);
}
