package core.basesyntax.service.interfaces;

import core.basesyntax.model.dto.FruitRecordDto;

public interface ParserService {
    FruitRecordDto parse(String line);
}
