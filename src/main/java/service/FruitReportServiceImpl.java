package service;

import java.util.Map;
import model.Fruit;
import storage.Storage;

public class FruitReportServiceImpl implements FruitReportService {
    private static final String COMMA = ",";
    private static final String TITLE_RESULT = "fruit,quantity";

    @Override
    public String returnReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE_RESULT);
        for (Map.Entry<Fruit,Integer> entry : Storage.fruitStorage.entrySet()) {
            stringBuilder.append(System.lineSeparator()).append(entry.getKey().getFruitName())
                    .append(COMMA).append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
