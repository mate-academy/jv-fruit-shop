package core.basesyntax.service;

import core.basesyntax.model.FruitRecordDto;
import java.util.List;

public interface RecordDtoParser {
    List<FruitRecordDto> parse(List<String> dataFromFile);
}
