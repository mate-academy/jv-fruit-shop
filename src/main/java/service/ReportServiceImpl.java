package service;

import database.StorageFruits;
import java.util.Map;
import shop.Fruit;

public class ReportServiceImpl implements ReportService {
    private static final String HEAD = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String makeReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEAD);
        for (Map.Entry<Fruit, Integer> entry : StorageFruits.storageFruits.entrySet()) {
            stringBuilder.append("\n")
                    .append(entry.getKey().getName())
                    .append(SEPARATOR)
                    .append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
