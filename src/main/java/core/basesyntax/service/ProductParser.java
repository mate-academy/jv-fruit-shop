package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ProductParser {
    FruitTransaction parse(String productInfo);

    List<FruitTransaction> parseAll(List<String> list);
}
