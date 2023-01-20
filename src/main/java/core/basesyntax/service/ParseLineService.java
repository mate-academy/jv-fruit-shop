package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParseLineService {
    List<FruitTransaction> getFruitTransaction(List<String> listLines);
}
