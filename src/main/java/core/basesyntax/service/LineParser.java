package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import java.util.List;

public interface LineParser {

    List<FruitTransaction> createListOfTransactions(List<String> lines);
}
