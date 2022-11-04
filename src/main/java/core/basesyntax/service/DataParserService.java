package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataParserService {
    List<FruitTransaction> parseFruits(List<String> linesFromInputFile);
}
