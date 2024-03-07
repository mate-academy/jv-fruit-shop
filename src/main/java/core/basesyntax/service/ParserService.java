package core.basesyntax.service;

import java.util.List;
import core.basesyntax.model.FruitTransaction;

public interface ParserService {
    List<FruitTransaction> parse(List<String> commands);

}
