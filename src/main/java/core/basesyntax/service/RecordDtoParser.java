package core.basesyntax.service;

import core.basesyntax.dto.FruitRecordDto;
import java.util.List;

public interface RecordDtoParser {
    List<FruitRecordDto> parse(List<String> dataFromFile);
}
