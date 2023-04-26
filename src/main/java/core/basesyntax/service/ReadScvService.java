package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ReadScvService {
    public List<FruitTransaction> readFromFileInputCsv();
}
