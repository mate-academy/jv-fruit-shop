package core.basesyntax.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ConvertToCsvService;
import java.util.ArrayList;
import java.util.List;

public class ConvertToCsvServiceImpl implements ConvertToCsvService {
    private static final String[] HEADER = {"fruits", "quantity" + System.lineSeparator(),};
    private static final int STORAGE_SIZE = Storage.fruits.size();

    @Override
    public List<String[]> convertedList() {
        List<String[]> result = new ArrayList<>();
        result.add(HEADER);
        Object[] keys = Storage.fruits.keySet().toArray();
        for (int i = 0; i < STORAGE_SIZE; i++) {
            String[] column = new String[]{String.valueOf(keys[i]),
                    Storage.fruits.get(keys[i]) + System.lineSeparator(),
            };
            result.add(column);
        }
        return result;
    }
}
