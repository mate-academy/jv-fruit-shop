package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.WriteService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteServiceImpl implements WriteService {
    private static final String SEPARATOR = ",";

    @Override
    public void wrightToFile(String fileName) {
        StringBuilder report = new StringBuilder("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.fruitStorage.entrySet()) {
            report.append(entry.getKey()).append(SEPARATOR)
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(String.valueOf(report));
        } catch (IOException e) {
            throw new RuntimeException("Can't wright to file " + fileName, e);
        }
    }
}
