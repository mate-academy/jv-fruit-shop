package core.basesyntax.converter;

import core.basesyntax.storage.Storage;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder result = new StringBuilder("fruit,quantity\n");
        Storage.fruitStorage.forEach((key, value) -> {
            result.append(key).append(",").append(value).append(System.lineSeparator());
        });
        return result.toString();
    }
}
