package core.basesyntax.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ConverterService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConverterServiceImpl implements ConverterService {
    private static final String[] HEADER = {"fruits", "quantity" + System.lineSeparator(),};

    @Override
    public List<String[]> convertList() {
        List<String[]> result = new ArrayList<>();
        result.add(HEADER);
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            String[] column = new String[]{
                    entry.getKey(),
                    Storage.fruits.get(entry.getKey()) + System.lineSeparator(),
            };
            result.add(column);
        }
        return result;
    }
}
