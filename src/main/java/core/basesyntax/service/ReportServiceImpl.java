package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity" + System.lineSeparator());

        for (Map.Entry<String, Integer> map : Storage.fruitStorage.entrySet()) {
            stringBuilder
                    .append(map.getKey())
                    .append(",").append(map.getValue())
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }

}