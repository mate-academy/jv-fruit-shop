package core.basesyntax.service;

import core.basesyntax.model.FruitRecordDto;
import java.util.List;

public interface FruitParse {
    List<FruitRecordDto> parse(List<String> lines);
}
