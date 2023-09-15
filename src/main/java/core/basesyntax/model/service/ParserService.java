package core.basesyntax.model.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParserService {
    List<FruitTransaction> parseTransaction(List<String> lines);
}
