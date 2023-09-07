package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FileDataConvertorService {
    List<FruitTransaction> convertToFruitTransaction(List<String> fileLines);
}
