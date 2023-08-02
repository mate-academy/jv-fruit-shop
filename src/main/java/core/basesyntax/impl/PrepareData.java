package core.basesyntax.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.Preparer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrepareData implements Preparer {
    private static final String COMMA = ",";
    private final Storage storage = new Storage();

    public List<String> prepare() {
        List<String> preparedForWrite = new ArrayList<>();
        preparedForWrite.add("fruit,quantity");
        for (Map.Entry<String, Integer> data : storage.getStorage().entrySet()) {
            preparedForWrite.add(data.getKey() + COMMA + data.getValue());
        }
        return preparedForWrite;
    }
}
