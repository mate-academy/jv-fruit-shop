package core.basesyntax.service;

import core.basesyntax.model.dto.FruitRecordDto;
import java.util.List;

public interface FruitRecordDtoParser {
    List<FruitRecordDto> parseLines(List<String> records);
}
