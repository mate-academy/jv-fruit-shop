package core.basesyntax.service;

import core.basesyntax.model.dto.FruitRecordDto;
import java.util.List;

public interface DtoParser {
    List<FruitRecordDto> parse(List<String> fileLines);
}
