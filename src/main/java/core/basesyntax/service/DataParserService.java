package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataParserService {
    List<FruitTransaction> getFruitsToList(List<String> linesFromInputFile);
}
