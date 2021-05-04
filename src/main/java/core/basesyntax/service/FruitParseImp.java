package core.basesyntax.service;

import core.basesyntax.model.FruitRecordDto;
import java.util.List;

public interface FruitParseImp {
    List<FruitRecordDto> parse(List<String> lines);
}
