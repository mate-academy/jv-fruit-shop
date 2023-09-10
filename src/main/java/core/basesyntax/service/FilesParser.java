package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FilesParser {
    List<FruitTransaction> parseFruitTransaction(List<String> data);
}
