package core.basesyntax.service;

import core.basesyntax.model.dto.FruitRecordDto;
import java.util.List;

public interface ParseToList {
    List<FruitRecordDto> parseToDto(List<String> dataFromFile);
}
