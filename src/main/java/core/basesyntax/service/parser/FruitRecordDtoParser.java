package core.basesyntax.service.parser;

import core.basesyntax.dto.FruitRecordDto;
import java.util.List;

public interface FruitRecordDtoParser {
    List<FruitRecordDto> parse(List<String> lines);
}
