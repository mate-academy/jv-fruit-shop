package core.basesyntax.fruitshop.service;

import core.basesyntax.fruitshop.model.FruitTransaction;
import java.util.List;

public interface ParserService {
    List<FruitTransaction> parse(List<String> lines);
}
