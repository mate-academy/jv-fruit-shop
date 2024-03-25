package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface IFruitTransactionParsing {
    List<FruitTransaction> parse(List<String> lineList);
}
