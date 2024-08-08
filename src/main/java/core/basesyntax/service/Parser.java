package core.basesyntax.service;

import core.basesyntax.model.FruitOperation;
import java.util.List;

public interface Parser {
    List<FruitOperation> parse(List<String[]> lines);
}
