package core.basesyntax.servise;

import java.util.List;

public interface ParserService {
    List<FruitTransaction> parsingData(List<String> inputList);
}
