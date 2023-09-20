package core.basesyntax;

import static core.basesyntax.model.FruitStorage.STORAGE;

import core.basesyntax.filework.ReportCreatorService;
import java.util.Map;

class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String FIRST_STRING = "fruit,quantity" + System.lineSeparator();
    private static final String COMMA = ",";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder(FIRST_STRING);
        builder.append(System.lineSeparator());
        for (Map.Entry<String,Integer> fruits : STORAGE.entrySet()) {
            builder.append(fruits.getKey()).append(COMMA).append(fruits.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
