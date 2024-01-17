package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.List;

public class CsvFileDaoImpl implements FileDao {
    private static final int INITIAL_VALUE_OF_QUANTITY = 0;
    private static final String COMMA = ",";

    @Override
    public void addToStorage(List<String> readFile, Storage storage) {
        readFile
                .forEach(string ->
                    storage.getFruitQuantityMap().put(string, INITIAL_VALUE_OF_QUANTITY));
    }
}
