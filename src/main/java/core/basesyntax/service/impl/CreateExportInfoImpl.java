package core.basesyntax.service.impl;

import static core.basesyntax.db.Storage.fruitStorage;
import java.util.Map;
import core.basesyntax.service.CreateExportInfo;

public class CreateExportInfoImpl implements CreateExportInfo {
    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity");
        for (Map.Entry<String, Integer> entry : fruitStorage.entrySet()) {
            stringBuilder.append("\n" + entry.getKey() + "," + entry.getValue());
        };
        return stringBuilder.toString();
    }
}
