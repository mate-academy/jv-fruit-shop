package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;
import java.util.Map;

public interface Parser {
    List<FruitTransaction> parse(List<String> data);
}
