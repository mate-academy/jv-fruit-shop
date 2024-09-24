package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FileReader {
    List<FruitTransaction> readFile(String fileName);
}
