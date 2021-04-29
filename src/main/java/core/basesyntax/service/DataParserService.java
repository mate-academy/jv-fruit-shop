package core.basesyntax.service;

import core.basesyntax.model.dto.FruitDataDto;
import java.util.List;

public interface DataParserService {
    List<FruitDataDto> parseDataFromInputFile(List<String> dataFromInputFile);
}
