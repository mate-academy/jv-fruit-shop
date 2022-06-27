package core.basesyntax.service;

import core.basesyntax.model.FruitShopTransactions;
import java.util.List;

public interface FruitParser {
    List<FruitShopTransactions> parse(List<String> list);
}
