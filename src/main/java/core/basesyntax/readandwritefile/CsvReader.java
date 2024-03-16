package core.basesyntax.readandwritefile;

import core.basesyntax.FruitTransaction;
import java.util.List;

public interface CsvReader {
    List<FruitTransaction> readDataFromDataBase();
}
