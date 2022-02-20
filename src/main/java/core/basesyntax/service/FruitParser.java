package core.basesyntax.service;

import core.basesyntax.dto.FruitRecordDto;
import java.util.List;

public interface FruitParser {
    List<FruitRecordDto> parse(List<String> lines);
}
