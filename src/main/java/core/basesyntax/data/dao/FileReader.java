package core.basesyntax.data.dao;

import core.basesyntax.data.model.FruitTransaction;
import java.util.List;

public interface FileReader {
    List<FruitTransaction> readFile(String fileName);
}

