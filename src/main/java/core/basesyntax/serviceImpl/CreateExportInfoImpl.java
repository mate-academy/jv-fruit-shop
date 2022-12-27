package core.basesyntax.serviceImpl;

import core.basesyntax.service.CreateExportInfo;

import java.util.Map;

import static core.basesyntax.db.Storage.fruitStorage;

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
