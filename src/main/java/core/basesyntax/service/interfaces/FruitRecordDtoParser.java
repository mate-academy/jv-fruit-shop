package core.basesyntax.service.interfaces;

import core.basesyntax.model.dto.FruitRecordDto;
import java.util.List;

public interface FruitRecordDtoParser {
    List<FruitRecordDto> parse(List<String> lines);
}
