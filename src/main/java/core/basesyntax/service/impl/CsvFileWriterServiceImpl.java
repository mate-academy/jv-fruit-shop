package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.CsvFileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";
    private static final String COMA_SEPARATOR = ",";

    @Override
    public void writeToFile(String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            writeFirstLine(bufferedWriter);
            for (Map.Entry<String, Integer> data : Storage.dataStorage.entrySet()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(data.getKey())
                        .append(COMA_SEPARATOR)
                        .append(data.getValue())
                        .append(System.lineSeparator());
                bufferedWriter.write(stringBuilder.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant find file on path: " + path, e);
        }
    }

    private void writeFirstLine(BufferedWriter bufferedWriter) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FRUIT)
                .append(COMA_SEPARATOR)
                .append(QUANTITY)
                .append(System.lineSeparator());
        bufferedWriter.write(stringBuilder.toString());
    }
}
