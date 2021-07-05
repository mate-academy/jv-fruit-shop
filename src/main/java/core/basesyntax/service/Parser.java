package core.basesyntax.service;

import core.basesyntax.dto.FruitDto;
import java.util.List;

public interface Parser {
    List<FruitDto> parseAndValidateLine(List<String> lines);
}
