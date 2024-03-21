package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParserService<T> {
    List<FruitTransaction> parse(List<T> input);
}
