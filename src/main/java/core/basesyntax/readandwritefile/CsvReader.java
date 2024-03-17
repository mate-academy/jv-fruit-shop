package core.basesyntax.readandwritefile;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface CsvReader {
    List<FruitTransaction> readDataFromDataBase();
}
