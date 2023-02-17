package core.basesyntax.service;

import core.basesyntax.model.FruitOperation;
import java.util.List;

public interface FileParser {
    List<FruitOperation> parse(List<String> list);
}
