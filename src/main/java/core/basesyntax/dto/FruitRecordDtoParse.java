package core.basesyntax.dto;

import java.util.List;

public interface FruitRecordDtoParse {
    List<FruitRecordDto> parse(List<String> lines);
}
