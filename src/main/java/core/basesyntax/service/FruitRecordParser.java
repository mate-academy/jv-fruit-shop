package core.basesyntax.service;

import core.basesyntax.model.dto.FruitRecordDto;
import java.util.List;

public interface FruitRecordParser {
    List<FruitRecordDto> parse(List<String> data);
}
