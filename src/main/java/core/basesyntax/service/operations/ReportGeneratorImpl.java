package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        //storage = (Storage) Storage.fruits;
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity")
                .append(System.lineSeparator());
        for (String name: Storage.fruits.keySet()) {
            String key = name.toString();
            String value = Storage.fruits.get(name).toString();
            builder.append(key + "," + value)
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
