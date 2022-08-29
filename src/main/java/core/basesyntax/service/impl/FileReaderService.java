package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FileReaderService {

    List<FruitTransaction> read(String fileName);
}
