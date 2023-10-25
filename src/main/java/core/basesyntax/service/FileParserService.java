package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FileParserService {
    List<FruitTransaction> parse(List<String> data);
}
