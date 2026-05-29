package core.basesyntax.service.converting;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private final Map<String, FruitTransaction> storage = Storage.storage;

    @Override
    public void getReport(String reportFileName) {
        StringBuilder result = new StringBuilder("fruit,quantity" + "\n");

        for (Map.Entry<String, FruitTransaction> elements : storage.entrySet()) {
            result.append(elements.getKey())
                    .append(",")
                    .append(elements.getValue().getQuantity())
                    .append("\n");
        }

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reportFileName))) {
            fileWriter.write(result.toString());
        } catch (IOException e) {
            throw new RuntimeException("can not write data to file");
        }
    }
}
