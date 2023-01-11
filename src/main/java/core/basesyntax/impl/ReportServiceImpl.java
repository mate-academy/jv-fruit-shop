package core.basesyntax.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String[] HEADER = {"fruits", "quantity"};

    @Override
    public List<String[]> createReport() {
        List<String[]> convertedList = new ArrayList<>();
        convertedList.add(HEADER);
        Object[] keys = Storage.fruits.keySet().toArray();
        for (int i = 0; i < Storage.fruits.size(); i++) {
            String[] column = new String[]{String.valueOf(keys[i]),
                    String.valueOf(Storage.fruits.get(keys[i]))};
            convertedList.add(column);
        }
        return convertedList;
    }
}
