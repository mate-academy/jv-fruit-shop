package core.basesyntax.service.impl;

import core.basesyntax.Storage;
import core.basesyntax.service.interfaces.FruitService;
import core.basesyntax.service.operations.Operation;
import java.util.Map;

public class ReportMaker implements FruitService {
    private static final int OPERATION = 0;
    private static final int KEY = 1;
    private static final int INPUT = 2;

    private final Map<String, Operation> strategyMap;

    public ReportMaker(Map<String, Operation> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public void saveDataToStorage(String[] record) {
        Storage.storage.put(record[KEY], strategyMap.get(record[OPERATION])
                .operation(Storage.storage.get(record[KEY]), Integer.parseInt(record[INPUT])));
    }

    @Override
    public String getDataFromStorage() {
        String result = "fruit,quantity";
        for (Map.Entry<String, Integer> record : Storage.storage.entrySet()) {
            result = result + System.lineSeparator() + record.getKey() + "," + record.getValue();
        }
        return result;
    }
}
