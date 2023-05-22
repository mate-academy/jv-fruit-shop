package core.basesyntax.service;

import core.basesyntax.strategy.FruitTransaction;
import java.util.List;

public interface Parser {
    List<FruitTransaction> parse(List<String> input);
}
