package core.basesyntax.cvswork;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FileRead {
    List<FruitTransaction> readParser(String csv);
}
