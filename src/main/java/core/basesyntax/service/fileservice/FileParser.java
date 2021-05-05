package core.basesyntax.service.fileservice;

import core.basesyntax.model.dto.FruitRecordDto;
import java.util.List;

public interface FileParser {
    List<FruitRecordDto> parser(List<String> lines);
}
