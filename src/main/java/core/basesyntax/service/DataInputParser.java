package core.basesyntax.service;

import java.util.List;

public interface DataInputParser {
    List<FruitTransaction> parseData(List<String> dataList);
}
