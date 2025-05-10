package core.basesyntax.service.parser;

import core.basesyntax.service.FruitTransaction;
import java.util.List;

public interface ParseFruitData {
    List<FruitTransaction> parseData(List<String> fileInput);
}
