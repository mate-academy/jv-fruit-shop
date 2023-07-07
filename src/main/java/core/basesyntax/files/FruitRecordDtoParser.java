package core.basesyntax.files;

import core.basesyntax.model.dto.FruitRecordDto;
import java.util.List;

public interface FruitRecordDtoParser {
    List<FruitRecordDto> parseStrings(List<String> lines);
}
